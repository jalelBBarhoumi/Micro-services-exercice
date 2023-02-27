package com.insy2s.microservices.controller;

import com.insy2s.microservices.dto.UserRequest;
import com.insy2s.microservices.dto.UserResponse;
import com.insy2s.microservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  createProduct(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
