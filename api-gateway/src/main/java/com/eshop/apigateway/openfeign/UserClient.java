package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("user-service/auth/users")
public interface UserClient {

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @PutMapping("/users/{id}")
    ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser);

    @DeleteMapping("/users/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id);
}
