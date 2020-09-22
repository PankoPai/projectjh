package com.example.projectjh.converters;

import com.example.projectjh.commands.DeveloperCommand;
import com.example.projectjh.model.Developer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

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
