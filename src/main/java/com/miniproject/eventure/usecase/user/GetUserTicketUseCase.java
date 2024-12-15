package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.infrastructure.user.dto.GetUserTicketResponseDTO;

import java.util.List;

public interface GetUserTicketUseCase {
    List<GetUserTicketResponseDTO> getUserTicketById(Long userId);
}
