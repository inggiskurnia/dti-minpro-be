package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import lombok.Data;

@Data
public class GetEventOrganizerResponseDTO {
    private Long eventOrganizerId;
    private User user;
    private String name;
    private City city;
    private String description;
    private String profilePictureLink;

    public GetEventOrganizerResponseDTO(EventOrganizer eventOrganizer){
        this.eventOrganizerId = eventOrganizer.getEventOrganizerId();
        this.user = eventOrganizer.getUser();
        this.name = eventOrganizer.getName();
        this.city = eventOrganizer.getCity();
        this.description = eventOrganizer.getDescription();
        this.profilePictureLink = eventOrganizer.getProfilePictureLink();
    }
}
