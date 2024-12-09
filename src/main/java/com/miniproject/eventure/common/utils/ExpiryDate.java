package com.miniproject.eventure.common.utils;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;

@Service
public class ExpiryDate {

    public OffsetDateTime calculateExpiryDate(String durationRequest) {
        if (durationRequest.isEmpty()) {
            return null;
        }
        Duration duration = Duration.parse(durationRequest);

        return OffsetDateTime.now().plus(duration);
    }
}
