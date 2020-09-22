package com.example.projectjh.controllers;

import com.example.projectjh.commands.DeveloperCommand;
import com.example.projectjh.converters.DeveloperCommandToDeveloper;
import com.example.projectjh.model.Developer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.projectjh.repositories.DeveloperRepository;

import java.util.Optional;

@Controller
public class DeveloperController {
    private DeveloperRepository developerRepository;

    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @RequestMapping("/developer")
    public String getDevelopers(Model model, @PathVariable("id") Long id) {

        model.addAttribute("developers", developerRepository.findById(id).get());
        return "developer/show";
    }

    @GetMapping("/developer/new")
    public String newDeveloper(Model model) {
        model.addAttribute("developer", new DeveloperCommand());
        return "developer/addedit";
    }

    @PostMapping("developer")

    public String saveOrUpdate(@ModelAttribute DeveloperCommand command){
        Optional<Developer> developerOptional = developerRepository.getFirstByName(command.getName());
        if (!developerOptional.isPresent()) {
            Developer detachedDeveloper = DeveloperCommandToDeveloper.convert(command);
            Developer savedDeveloper = developerRepository.save(detachedDeveloper);
            return "redirect:/developer/" + savedDeveloper.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such developer in db");
            return "redirect:/developer/" + developerOptional.get().getId() + "/show";
        }
    }
}
