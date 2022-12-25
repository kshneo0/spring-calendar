package com.calendar.api.dto;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */


import com.calendar.core.domain.entity.Share;
import lombok.Data;

@Data
public class CreateShareReq {
    private final Long toUserId;
    private final Share.Direction direction;
}