package com.eshop.userservice.service.impl;


import com.eshop.userservice.entity.User;
import com.eshop.userservice.repository.UserRepository;
import com.eshop.userservice.security.JwtUserDetails;
import com.eshop.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails findByUsername(String username) {
		Optional<User> userOptional = userRepository.findOneByUsername(username);
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		return new JwtUserDetails(user);
	}

	@Override
	public UserDetailsService userDetailsService() {
		return this::findByUsername;
	}


	@Transactional
	public void update(User user) {
		userRepository.saveAndFlush(user);
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
