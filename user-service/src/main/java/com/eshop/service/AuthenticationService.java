package com.eshop.service;

import com.eshop.dto.JwtAuthenticationResponse;
import com.eshop.dto.SignInRequest;
import com.eshop.dto.SignUpRequest;

public interface AuthenticationService {
	JwtAuthenticationResponse signUp(SignUpRequest request);

	JwtAuthenticationResponse signIn(SignInRequest request);
}
