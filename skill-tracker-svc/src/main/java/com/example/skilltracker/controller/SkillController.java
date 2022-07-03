package com.example.skilltracker.controller;

import com.example.skilltracker.controller.dto.SkillDto;
import com.example.skilltracker.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    SkillService skillservice;

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills(){
        List<SkillDto> skillDtoList = skillservice.getAllSkills()
                .stream()
                .map(user -> modelMapper.map(user, SkillDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(skillDtoList);
    }
}
