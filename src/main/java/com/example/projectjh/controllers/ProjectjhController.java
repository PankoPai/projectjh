package com.example.projectjh.controllers;

import com.example.projectjh.commands.DeveloperCommand;
import com.example.projectjh.converters.DeveloperCommandToDeveloper;
import com.example.projectjh.model.Developer;
import com.example.projectjh.repositories.GameRepository;
import com.example.projectjh.repositories.DeveloperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProjectjhController {

    @RequestMapping(value = {"/"})
    public String getDevelopers() {
        return "index";
    }
}
