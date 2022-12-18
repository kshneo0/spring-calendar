package com.calendar.core.exception;

import lombok.Getter;

/**
 * fileName : CalendarException
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Getter
public class CalendarException extends RuntimeException {
    private final ErrorCode errorCode;

    public CalendarException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
