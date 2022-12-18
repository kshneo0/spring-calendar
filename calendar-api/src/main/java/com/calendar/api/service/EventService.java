package com.calendar.api.service;

import com.calendar.api.dto.AuthUser;
import com.calendar.api.dto.EventCreateReq;
import com.calendar.api.dto.TaskCreateReq;
import com.calendar.core.domain.RequestStatus;
import com.calendar.core.domain.entity.Engagement;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.User;
import com.calendar.core.domain.entity.repository.EngagementRepository;
import com.calendar.core.domain.entity.repository.ScheduleRepository;
import com.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * fileName : TaskService
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Service
@RequiredArgsConstructor
public class EventService {

    private final EmailService emailService;
    private final UserService userService;
    private final ScheduleRepository scheduleRepository;
    private final EngagementRepository engagementRepository;

    @Transactional
    public void create(EventCreateReq eventCreateReq, AuthUser authUser) {
        //이벤트 참여자의 다른 이벤트와 중목이 되면 안 된다.
        //1-2까지 회의가 있는데, 추가로 다른 회의를 등록할 수 없음.
        //추가로 이메일 발송..?
        final List<Engagement> engagementList = engagementRepository.findAll(); //TODO findAll 개선
        if(engagementList.stream()
                .anyMatch(e -> eventCreateReq.getAttendeeIds().contains(e.getAttendee().getId())
                        && e.getRequestStatus() == RequestStatus.ACCEPTED
                && e.getEvent().isOverlapped(eventCreateReq.getStartAt(),
                        eventCreateReq.getEndAt()))
        ) {
            throw new RuntimeException("cannot make engagement. period overlapped!");
        }
        final Schedule eventSchedule =
                Schedule.event(eventCreateReq.getTitle(),
                        eventCreateReq.getDescription(),
                        eventCreateReq.getStartAt(),
                        eventCreateReq.getEndAt(),
                        userService.findByUserId(authUser.getId()));
        scheduleRepository.save(eventSchedule);

        eventCreateReq.getAttendeeIds()
                .forEach(atId -> {
                    final User attendee = userService.findByUserId(atId);
                    final Engagement engagement = Engagement.builder()
                            .schedule(eventSchedule)
                            .requestStatus(RequestStatus.REQUESTED)
                            .attendee(attendee)
                            .build();
                    engagementRepository.save(engagement);
                    emailService.sendEngagement(engagement);
                });
    }
}
