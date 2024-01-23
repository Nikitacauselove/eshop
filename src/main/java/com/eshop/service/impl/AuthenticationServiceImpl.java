package com.eshop.service.impl;

import com.eshop.dto.JwtAuthenticationResponse;
import com.eshop.dto.SignInRequest;
import com.eshop.dto.SignUpRequest;
import com.eshop.entity.Role;
import com.eshop.entity.User;
import com.eshop.security.JwtUserFactory;
import com.eshop.service.AuthenticationService;
import com.eshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	private final UserService userService;
	private final JwtServiceImpl jwtTokenProvider;
	private final PasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;

	@Transactional
	@Override
	public JwtAuthenticationResponse signUp(SignUpRequest request) {
		var user = User.builder()
				.username(request.username())
				.email(request.email())
				.password(passwordEncoder.encode(request.password()))
				.firstname(request.firstname())
				.role(Role.ROLE_USER)
				.address(request.address())
				.build();

		userService.save(user);

		UserDetails userDetails = JwtUserFactory.create(user);
		String token = jwtTokenProvider.generateToken(userDetails);
		return new JwtAuthenticationResponse(token);
	}

	@Transactional
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
