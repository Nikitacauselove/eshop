package com.eshop.userservice.service.impl;

import com.eshop.userservice.dto.JwtAuthenticationResponse;
import com.eshop.userservice.dto.SignInRequest;
import com.eshop.userservice.dto.SignUpRequest;
import com.eshop.userservice.entity.Role;
import com.eshop.userservice.entity.User;
import com.eshop.userservice.security.JwtUserDetails;
import com.eshop.userservice.service.AuthenticationService;
import com.eshop.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	private final UserService userService;
	private final JwtServiceImpl jwtTokenProvider;
	private final PasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;

	public JwtAuthenticationResponse signUp(SignUpRequest request) {
		var user = User.builder()
				.username(request.username())
				.email(request.email())
				.password(passwordEncoder.encode(request.password()))
				.firstname(request.firstname())
				.role(Role.ROLE_USER)
				.build();

		userService.save(user);

		UserDetails userDetails = new JwtUserDetails(user);
		String token = jwtTokenProvider.generateToken(userDetails);
		return new JwtAuthenticationResponse(token);
	}

	@Override
	public JwtAuthenticationResponse signIn(SignInRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.username(),
				request.password()
		));

		UserDetails userDetails = userService.userDetailsService().loadUserByUsername(request.username());
		String token = jwtTokenProvider.generateToken(userDetails);
		return new JwtAuthenticationResponse(token);
	}
}
