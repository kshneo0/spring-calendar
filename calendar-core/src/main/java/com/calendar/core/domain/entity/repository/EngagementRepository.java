package com.calendar.core.domain.entity.repository;

import com.calendar.core.domain.entity.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName : EngagementRepository
 * author :  KimSangHoon
 * date : 2022/12/16
 */
public interface EngagementRepository extends JpaRepository<Engagement, Long> {
}
