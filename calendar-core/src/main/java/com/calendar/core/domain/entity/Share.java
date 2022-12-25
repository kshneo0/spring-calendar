package com.calendar.core.domain.entity;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */
import com.calendar.core.domain.RequestReplyType;
import com.calendar.core.domain.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Entity
@Table(name = "shares")
@NoArgsConstructor
@AllArgsConstructor
public class Share extends BaseEntity {

    private Long fromUserId;
    private Long toUserId;
    @Enumerated(value = EnumType.STRING)
    private RequestStatus requestStatus;
    @Enumerated(value = EnumType.STRING)
    private Direction direction; // From 이 To 에게 요청. 단방향인 경우는 To 의 캘린더가 From 에 보인다.

    public Share reply(RequestReplyType type) {
        switch (type) {
            case ACCEPT:
                this.requestStatus = RequestStatus.ACCEPTED;
                break;
            case REJECT:
                this.requestStatus = RequestStatus.REJECTED;
                break;
        }
        return this;
    }

    public enum Direction {
        BI_DIRECTION, UNI_DIRECTION
    }
}