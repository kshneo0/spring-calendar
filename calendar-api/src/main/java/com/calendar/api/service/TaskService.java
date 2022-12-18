package com.calendar.api.service;

import com.calendar.api.dto.AuthUser;
import com.calendar.api.dto.TaskCreateReq;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.repository.ScheduleRepository;
import com.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * fileName : TaskService
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Service
@RequiredArgsConstructor
public class TaskService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(TaskCreateReq taskCreateReq, AuthUser authUser) {
        final Schedule taskSchedule =
                Schedule.task(taskCreateReq.getTitle(),
                        taskCreateReq.getDescription(),
                        taskCreateReq.getTaskAt(),
                        userService.findByUserId(authUser.getId()));
        scheduleRepository.save(taskSchedule);
    }
}
