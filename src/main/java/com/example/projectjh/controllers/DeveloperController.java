package com.example.projectjh.controllers;

import com.example.projectjh.commands.DeveloperCommand;
import com.example.projectjh.converters.DeveloperCommandToDeveloper;
import com.example.projectjh.model.Developer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.projectjh.repositories.DeveloperRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DeveloperController {
    private DeveloperRepository developerRepository;
    private DeveloperCommandToDeveloper developerCommandToDeveloper;

    public DeveloperController(DeveloperRepository developerRepository, DeveloperCommandToDeveloper developerCommandToDeveloper) {
        this.developerRepository = developerRepository;
        this.developerCommandToDeveloper = developerCommandToDeveloper;
    }

    @RequestMapping(value = {"/developers", "/developer/list"})
    public String getDevelopers(Model model, @PathVariable("id") Long id) {
        model.addAttribute("developer", developerRepository.findById(id).get());
        return "developer/show";
    }

    @RequestMapping("/developer/{id}/show")
    public String getDeveloperDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("developer", developerRepository.findById(id).get());
        return "developer/show";
    }

    @RequestMapping("/developer/{id}/delete")
    public String deleteDeveloper(@PathVariable("id") Long id) {
        developerRepository.deleteById(id);
        return "redirect:/developers";
    }

    @GetMapping
    @RequestMapping("/developer/new")
    public String newGame(Model model){
        model.addAttribute("developer", new DeveloperCommand());
        return "developer/addedit";
    }

    @PostMapping("developer")
    public String saveOrUpdate(@ModelAttribute DeveloperCommand command){

        Optional<Developer> developerOptional = developerRepository.getDeveloperByName(command.getName());

        if (!developerOptional.isPresent()) {
            Developer detachedDeveloper = developerCommandToDeveloper.convert(command);
            Developer savedDeveloper = developerRepository.save(detachedDeveloper);
            return "redirect:/developer/" + savedDeveloper.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such developer in db");
            return "redirect:/developer/" + developerOptional.get().getId() + "/show";
        }
    }
}
