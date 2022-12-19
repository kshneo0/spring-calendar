package com.calendar.api.dto;

import com.calendar.core.domain.RequestReplyType;

/**
 * author :  sanghoonkim
 * date : 2022/12/20
 */
public class ReplyEngagementReq {
    private final RequestReplyType type;    //REJECT, ACCEPT

    public ReplyEngagementReq(RequestReplyType type) {
        this.type = type;
    }

    public RequestReplyType getType() {
        return type;
    }
}
