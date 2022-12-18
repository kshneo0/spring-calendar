package com.calendar.api.service;

import com.calendar.api.dto.AuthUser;
import com.calendar.api.dto.ScheduleDto;
import com.calendar.api.util.DtoConverter;
import com.calendar.core.domain.entity.repository.EngagementRepository;
import com.calendar.core.domain.entity.repository.ScheduleRepository;
import com.calendar.core.util.Period;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * fileName : ScheduleQueryService
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;
    private final EngagementRepository engagementRepository;

    public List<ScheduleDto> getScheduleByDay(AuthUser authUser, LocalDate date) {
        return getScheduleByPeriod(authUser, Period.of(date, date));
    }

    public List<ScheduleDto> getScheduleByWeek(AuthUser authUser, LocalDate startOfWeek) {
        return getScheduleByPeriod(authUser, Period.of(startOfWeek, startOfWeek.plusDays(6)));
    }

    public List<ScheduleDto> getScheduleByMonth(AuthUser authUser, YearMonth yearMonth) {
        return getScheduleByPeriod(authUser, Period.of(yearMonth.atDay(1), yearMonth.atEndOfMonth()));
    }

    private List<ScheduleDto> getScheduleByPeriod(AuthUser authUser, Period period) {
        return Stream.concat(scheduleRepository.findAllByWriter_Id(authUser.getId())
                .stream()
                .filter(schedule -> schedule.isOverlapped(period))
                .map(DtoConverter::fromSchedule), engagementRepository.findAllByAndAttendee_Id(authUser.getId())
                .stream()
                .filter(engagement -> engagement.isOverlapped(period))
                .map(engagement -> DtoConverter.fromSchedule(engagement.getSchedule()))).collect(Collectors.toList());
    }
}
