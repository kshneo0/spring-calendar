package com.calendar.core.domain.entity.repository;

import com.calendar.core.domain.entity.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * fileName : EngagementRepository
 * author :  KimSangHoon
 * date : 2022/12/16
 */
public interface EngagementRepository extends JpaRepository<Engagement, Long> {
    List<Engagement> findAllByAttendeeIdInAndSchedule_EndAtAfter(List<Long> attendeeIds, LocalDateTime startAt);

    List<Engagement> findAllByAttendeeId(Long id);
}
