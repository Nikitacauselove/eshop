package com.eshop.service;

import com.eshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	List<User> findAll();

	UserDetails findByUsername(String username);

	UserDetailsService userDetailsService();

	Optional<User> findById(Long id);

	void deleteById(Long id);

	void save(User user);
}


