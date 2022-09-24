package com.example.skilltracker.controller;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.enums.RoleType;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.service.UserService;
import com.example.skilltracker.service.UserTransformationService;
import com.example.skilltracker.util.SkilltrackerUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserTransformationService userTransformationService;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {

        LOGGER.info("Getting the user with id {}", id);

        UserDto userDto = modelMapper.map(userService.getUserById(id), UserDto.class);

        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping("/{roleType}")
    public ResponseEntity<UserDto> addUserProfile(@PathVariable RoleType roleType, @RequestBody UserDto userDto) {

        LOGGER.info("Adding user Profile for the user {}",userDto.getEmail());

        UserEntity userEntity = userTransformationService.userDtoToUserEntity(userDto);
        UserEntity savedUserEntity = userService.createUserProfile(userEntity,roleType);
        UserDto savedUserDto = modelMapper.map(savedUserEntity,UserDto.class);

        LOGGER.info("Profile Created Successfully for the user {}", savedUserDto.getEmail());

        return ResponseEntity.ok().body(savedUserDto);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUserProfile(@RequestBody UserDto userDto) {

        LOGGER.info("Updating user Profile for the user {}",userDto.getEmail());

        UserEntity userEntity = userTransformationService.userDtoToUserEntity(userDto);
        UserEntity savedUserEntity = userService.updateUserProfile(userEntity);
        UserDto savedUserDto = modelMapper.map(savedUserEntity,UserDto.class);

        LOGGER.info("Profile Created Successfully for the user {}", savedUserDto.getEmail());

        return ResponseEntity.ok().body(savedUserDto);
    }
}
