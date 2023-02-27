package com.insy2s.microservices.service;

import com.insy2s.microservices.dto.UserRequest;
import com.insy2s.microservices.dto.UserResponse;
import com.insy2s.microservices.model.User;
import com.insy2s.microservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest){
        User user= User.builder()
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .build();
        userRepository.save(user);
        log.info("User "+user.getId()+"is saved ");
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }
}
