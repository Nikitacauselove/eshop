package com.eshop.dto;

import jakarta.validation.constraints.NotEmpty;

public record JwtAuthenticationResponse(@NotEmpty String token) {
}
	