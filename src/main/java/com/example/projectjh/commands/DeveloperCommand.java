package com.example.projectjh.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Janusz Hlawiczka on 2020-30-06
 */

@Getter
@Setter
@NoArgsConstructor
public class DeveloperCommand {
    private Long id;
    private String name;
    private String year;
    private String country;
    private String hq;

}