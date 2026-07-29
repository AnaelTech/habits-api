package com.anaeltech.habits_api.dto.user.response;

import java.math.BigDecimal;

public record UserProfileResponse(
                Long id,
                String email,
                String firstName,
                String lastName,
                String avatarUrl,
                Integer size,
                BigDecimal weight) {

}
