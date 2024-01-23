package com.eshop.userservice.dto;

import jakarta.validation.constraints.NotEmpty;

public record JwtAuthenticationResponse(@NotEmpty String token) {
}
