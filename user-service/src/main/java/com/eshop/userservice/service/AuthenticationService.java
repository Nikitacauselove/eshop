package com.eshop.userservice.service;

import com.eshop.userservice.dto.JwtAuthenticationResponse;
import com.eshop.userservice.dto.SignInRequest;
import com.eshop.userservice.dto.SignUpRequest;

public interface AuthenticationService {
	JwtAuthenticationResponse signUp(SignUpRequest request);

	JwtAuthenticationResponse signIn(SignInRequest request);
}
