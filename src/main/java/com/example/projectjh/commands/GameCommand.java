package com.example.projectjh.commands;

import com.example.projectjh.model.Developer;
import com.example.projectjh.model.Publisher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameCommand {
    private Long id;
    private String title;
    private String genre;
    private String year;
    private Long developerId;
    private Long publisherId;
}
