package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.TransactionStatisticDTO;

public interface TransactionStatisticUseCase {
    TransactionStatisticDTO getTransactionStatistic(Long eventId, String range);  // range could be "year", "month", or "day"
}
