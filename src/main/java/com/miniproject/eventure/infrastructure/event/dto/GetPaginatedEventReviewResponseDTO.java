package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventReview;
import lombok.Data;

@Data
public class GetPaginatedEventReviewResponseDTO {
    private Long eventReviewId;
    private String eventName;
    private String userFullname;
    private String userProfilePicture;
    private Integer rating;
    private String description;

    public GetPaginatedEventReviewResponseDTO(EventReview eventReview){
        this.eventReviewId = eventReview.getEventReviewId();
        this.eventName = eventReview.getEventTicket().getEvent().getName();
        this.userFullname = eventReview.getUser().getFullName();
        this.userProfilePicture = eventReview.getUser().getProfilePicture();
        this.rating = eventReview.getRating();
        this.description = eventReview.getDescription();
    }
}
