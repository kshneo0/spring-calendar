package com.calendar.core.domain.entity.repository;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */
import com.calendar.core.domain.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {
}