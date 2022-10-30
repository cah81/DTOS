package com.dto.modelmapper.service;

import com.dto.modelmapper.dto.UserLocationDto;
import com.dto.modelmapper.model.User;
import com.dto.modelmapper.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public List<UserLocationDto> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }


    private UserLocationDto convertEntityToDto(User user){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDto userLocationDto = new UserLocationDto();
        userLocationDto = modelMapper.map(user,UserLocationDto.class);
        return userLocationDto;

    }

    private User converDtoToEntity(UserLocationDto userLocationDto){
        User user = new User();
        user = modelMapper.map(userLocationDto,User.class);
        return user;
    }
}
