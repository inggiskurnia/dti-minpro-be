package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEventTicketResponseDTO {
    private Long ticketId;
    private String ticketName;
    private Double price;
    private Integer totalAvailable;
    private String description;

    public GetEventTicketResponseDTO(EventTicket eventTicket){
        this.ticketId = eventTicket.getTicketId();
        this.ticketName = eventTicket.getTicketName();
        this.price = eventTicket.getPrice();
        this.totalAvailable = eventTicket.getTotalAvailable();
        this.description = eventTicket.getDescription();
    }
}
