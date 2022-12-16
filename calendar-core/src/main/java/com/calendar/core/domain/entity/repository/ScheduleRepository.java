package com.calendar.core.domain.entity.repository;

import com.calendar.core.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName : ScheduleRepository
 * author :  KimSangHoon
 * date : 2022/12/16
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
