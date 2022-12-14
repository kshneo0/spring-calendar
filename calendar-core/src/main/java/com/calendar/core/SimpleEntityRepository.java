package com.calendar.core;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName : SimpleEntityRepository
 * author :  KimSangHoon
 * date : 2022/12/14
 */
public interface SimpleEntityRepository  extends JpaRepository<SimpleEntity, Long> {

}
