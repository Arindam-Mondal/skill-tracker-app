package com.example.skilltracker.controller;

import com.example.skilltracker.controller.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        LOGGER.info("Getting all the users in the system");

        List<UserDto> userDtoList = userService.getAllUsers()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                                        .collect(Collectors.toList());

        LOGGER.info("There are {} users available in the system",userDtoList.size());

        return ResponseEntity.ok().body(userDtoList);
    }

    @PostMapping
    public ResponseEntity<UserDto> addUserProfile(@RequestBody UserDto userDto) {

        LOGGER.info("Adding user Profile for the user {}",userDto.getEmail());

        modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        UserEntity savedUserEntity = userService.createUserProfile(userEntity);
        UserDto savedUserDto = modelMapper.map(savedUserEntity,UserDto.class);

        LOGGER.info("Profile Created Successfully for the user {}", savedUserDto.getEmail());

        return ResponseEntity.ok().body(savedUserDto);
    }
}
