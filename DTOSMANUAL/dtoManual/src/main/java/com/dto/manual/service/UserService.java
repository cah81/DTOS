package com.dto.manual.service;

import com.dto.manual.dto.UserLocationDto;
import com.dto.manual.model.User;
import com.dto.manual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserLocationDto> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }


    private UserLocationDto convertEntityToDto(User user){

        UserLocationDto userLocationDto = new UserLocationDto();
        userLocationDto.setUserId(user.getId());
        userLocationDto.setEmail(user.getEmail());
        userLocationDto.setPlace(user.getLocation().getPlace());
        userLocationDto.setLongitude(user.getLocation().getLongitude());
        userLocationDto.setLatitude(user.getLocation().getLatitude());
        return userLocationDto;


    }
}
