package com.eshop.userservice.controller;

import com.eshop.userservice.dto.JwtAuthenticationResponse;
import com.eshop.userservice.dto.SignInRequest;
import com.eshop.userservice.dto.SignUpRequest;
import com.eshop.userservice.excetions.JwtAuthenticationException;
import com.eshop.userservice.service.AuthenticationService;
import com.eshop.userservice.utils.UserValidator;
import com.eshop.userservice.utils.ValidationHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
	private final UserValidator userValidator;
	private final AuthenticationService authenticationService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@ExceptionHandler({ JwtAuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(JwtAuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationHandler.extractErrors(bindingResult));
		} else {
			JwtAuthenticationResponse response = authenticationService.signUp(request);
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody @Valid SignInRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationHandler.extractErrors(bindingResult));
		} else {
			try {
				JwtAuthenticationResponse response = authenticationService.signIn(request);
				return ResponseEntity.ok(response);
			} catch (JwtAuthenticationException e) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
			}
		}
	}
}
