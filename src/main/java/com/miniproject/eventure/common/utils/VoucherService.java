package com.miniproject.eventure.common.utils;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.OffsetDateTime;

import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 7;
    private static final SecureRandom random = new SecureRandom();

    private String generateVoucherCode(String voucherName) {

        String namePart = voucherName.replaceAll("\\s+", "").toUpperCase();
        if (namePart.length() > 3) {
            namePart = namePart.substring(0, 3);
        }

        int suffixLength = CODE_LENGTH - namePart.length();
        StringBuilder suffix = new StringBuilder(suffixLength);
        for (int i = 0; i < suffixLength; i++) {
            suffix.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return namePart + suffix.toString();
    }

    public String generateUniqueVoucherCode(String voucherName) {
        String voucherCode;
        do {
            voucherCode = generateVoucherCode(voucherName);
        } while (voucherRepository.existsByCode(voucherCode));
        return voucherCode;
    }

    public OffsetDateTime calculateExpiryDate(String voucherDuration) {
        if (voucherDuration.isEmpty()) {
            return null;
        }
        Duration duration = Duration.parse(voucherDuration);

        return OffsetDateTime.now().plus(duration);
    }
}
