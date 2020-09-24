package com.example.projectjh.commands;

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
}
