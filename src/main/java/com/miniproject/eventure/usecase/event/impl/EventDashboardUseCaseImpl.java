package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.infrastructure.event.dto.EventDashboardDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.usecase.event.EventDashboardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventDashboardUseCaseImpl implements EventDashboardUseCase {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTicketRepository eventTicketRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<EventDashboardDTO> getEventDashboard(Long organizerId) {
        // Fetch events for the given organizer
        List<Event> events = eventRepository.findByOrganizer_EventOrganizerId(organizerId);
        List<EventDashboardDTO> dashboardDTOs = new ArrayList<>();

        for (Event event : events) {
            int totalTicketsSold = 0;
            BigDecimal totalRevenue = BigDecimal.ZERO;

            // Loop through each event ticket to calculate statistics
            List<EventTicket> eventTickets = eventTicketRepository.findByEvent(event);

            for (EventTicket ticket : eventTickets) {
                // Fetch transactions for this ticket
                List<Transaction> transactions = transactionRepository.findByEventTicket(ticket);

                totalTicketsSold += transactions.size(); // Count the number of transactions
                totalRevenue = totalRevenue.add(
                        transactions.stream()
                                .map(Transaction::getTotalAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                );
            }

            // Add the calculated stats to the dashboard DTO
            dashboardDTOs.add(new EventDashboardDTO(
                    event.getEventId(),
                    event.getName(),
                    event.getDescription(),
                    totalTicketsSold,
                    totalRevenue
            ));
        }

        return dashboardDTOs;
    }
}
