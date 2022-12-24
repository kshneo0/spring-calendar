package com.calendar.batch.job;

import lombok.*;

import java.time.LocalDateTime;

/**
 * author :  sanghoonkim
 * date : 2022/12/24
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendMailBatchReq {
    private Long id;    //scheduleId
    private LocalDateTime startAt;
    private String title;
    private String userMail;
}
