package com.calendar.api.util;

import com.calendar.api.dto.AuthUser;
import com.calendar.core.domain.RequestReplyType;
import com.calendar.core.domain.RequestStatus;
import com.calendar.core.domain.entity.repository.EngagementRepository;
import com.calendar.core.exception.CalendarException;
import com.calendar.core.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * author :  sanghoonkim
 * date : 2022/12/20
 */
@RequiredArgsConstructor
@Service
public class EngagementService {
    private final EngagementRepository engagementRepository;

    @Transactional
    public RequestStatus update(AuthUser authUser, Long engagementId, RequestReplyType type) {
        // engagement 조회
        // 참석자가 auth user와 같은지 비교
        // requested 상태인지 체크
        // update
        return engagementRepository.findById(engagementId)
                .filter(e -> e.getRequestStatus() == RequestStatus.REQUESTED)
                .filter(e -> e.getAttendee().getId().equals(authUser.getId()))
                .map(e -> e.reply(type))
                .orElseThrow(()-> new CalendarException(ErrorCode.BAD_REQUEST))
                .getRequestStatus();
    }
}
