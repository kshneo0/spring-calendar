package com.calendar.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * fileName : Event
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@Getter
@NoArgsConstructor
public class Event {
    private Long id;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String title;
    private String description;
    private User writer;
    private List<Engagement> engagements;
    private LocalDateTime createdAt;

    public Event(Long id, LocalDateTime startAt, LocalDateTime endAt, String title, String description, User writer, LocalDateTime createdAt) {
        this.id = id;
        this.startAt = startAt;
        this.endAt = endAt;
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.createdAt = createdAt;
    }


    public void addEngagement(Engagement engagement){
        if(engagements == null){
            engagements = Arrays.asList(engagement);
        } else {
            engagements.add(engagement);
        }

    }
}
