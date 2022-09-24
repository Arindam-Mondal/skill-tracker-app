package com.example.skilltracker.controller;

import com.example.skilltracker.dto.SkillDto;
import com.example.skilltracker.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skill")
@Slf4j
public class SkillController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SkillService skillservice;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills(){

        LOGGER.info("Getting all the available Skill in the system");

        List<SkillDto> skillDtoList = skillservice.getAllSkills()
                .stream()
                .map(user -> modelMapper.map(user, SkillDto.class))
                .collect(Collectors.toList());

        LOGGER.info("There are {} skills available in the system",skillDtoList.size() );

        return ResponseEntity.ok().body(skillDtoList);
    }
}
