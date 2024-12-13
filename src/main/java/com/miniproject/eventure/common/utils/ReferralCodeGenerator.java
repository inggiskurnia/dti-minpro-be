package com.miniproject.eventure.common.utils;

import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class ReferralCodeGenerator {

    private final UserRepository userRepository;

    public ReferralCodeGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateReferralCode(String fullName, OffsetDateTime birthdate) {
        String baseCode = createBaseCode(fullName, birthdate);
        String uniqueCode = baseCode;

        while (userRepository.existsByReferralCode(uniqueCode)) {
            uniqueCode = baseCode + getRandomSuffix();
        }
        return uniqueCode;
    }

    private static String createBaseCode(String fullName, OffsetDateTime birthdate) {
        String paddedName = fullName.replaceAll(" ", "");
        if (paddedName.length() < 5) {
            paddedName = String.format("%-5s", paddedName).replace(' ', 'X');
        }
        String namePart = paddedName.substring(0, 5).toUpperCase();

        String datePart = birthdate.format(DateTimeFormatter.ofPattern("ddYY")).substring(0, 3);

        return namePart + datePart;
    }

    private static String getRandomSuffix() {
        Random random = new Random();
        int suffix = random.nextInt(1000);
        return String.format("%03d", suffix);
    }
}

