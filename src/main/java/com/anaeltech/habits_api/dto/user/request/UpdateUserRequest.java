package com.anaeltech.habits_api.dto.user.request;

import java.math.BigDecimal;

public record UpdateUserRequest(
                String firstName,
                String lastName,
                Integer size,
                BigDecimal weight) {
}
