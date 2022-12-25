package com.calendar.api.dto;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */
import com.calendar.core.domain.RequestReplyType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ReplyReq {
    @NotNull
    private RequestReplyType type;
}