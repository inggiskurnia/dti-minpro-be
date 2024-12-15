package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.user.UserTicket;
import com.miniproject.eventure.infrastructure.user.dto.GetUserTicketResponseDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserTicketRepository;
import com.miniproject.eventure.usecase.user.GetUserTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserTicketUseCaseImpl implements GetUserTicketUseCase {
    @Autowired
    UserTicketRepository userTicketRepository;

    @Override
    public List<GetUserTicketResponseDTO> getUserTicketById(Long userId) {
        List<UserTicket> userTicket = userTicketRepository.findByUserUserId(userId);
        if(userTicket == null) {
            throw new DataNotFoundException("User tickets not found !");
        }

        return userTicket.stream().map(GetUserTicketResponseDTO::new).toList();
    }
}
