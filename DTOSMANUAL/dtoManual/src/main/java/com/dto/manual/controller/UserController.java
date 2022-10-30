package com.dto.manual.controller;

import com.dto.manual.dto.UserLocationDto;
import com.dto.manual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    public List<UserLocationDto> getUserLocation(){
        return userService.getAllUsersLocation();
    }
}
