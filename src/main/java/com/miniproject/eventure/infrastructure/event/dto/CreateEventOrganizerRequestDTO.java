package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEventOrganizerRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private String name;

    private Long cityId;

    private String description;

    private String profilePictureLink;

    public EventOrganizer toEntity(User user, City city) {
        EventOrganizer eventOrganizer = new EventOrganizer();
        eventOrganizer.setUser(user);
        eventOrganizer.setName(this.name);
        eventOrganizer.setCity(city);
        eventOrganizer.setDescription(this.description);
        eventOrganizer.setProfilePictureLink(this.profilePictureLink);
        return eventOrganizer;
    }
}
