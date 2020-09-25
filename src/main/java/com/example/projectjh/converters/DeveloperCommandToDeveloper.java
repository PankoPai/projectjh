package com.example.projectjh.converters;

import com.example.projectjh.commands.DeveloperCommand;
import com.example.projectjh.commands.GameCommand;
import com.example.projectjh.model.*;
import com.example.projectjh.repositories.DeveloperRepository;
import com.example.projectjh.repositories.PublisherRepository;
import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.lang.Nullable;

@Component
public class DeveloperCommandToDeveloper implements Converter<DeveloperCommand, Developer> {

    @Synchronized
    @Nullable
    @Override
    public Developer convert (DeveloperCommand source) {
        if (source == null) {
            return null;
        }
        final Developer developer = new Developer();
        developer.setName(source.getName());
        developer.setYear(source.getYear());
        developer.setHq(source.getHq());
        developer.setCountry(source.getCountry());

        return developer;
    }
}
