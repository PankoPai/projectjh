package com.example.projectjh.converters;

import com.example.projectjh.commands.GameCommand;
import com.example.projectjh.model.*;
import com.example.projectjh.repositories.DeveloperRepository;
import com.example.projectjh.repositories.PublisherRepository;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class GameCommandToGame implements Converter<GameCommand, Game> {

    private DeveloperRepository developerRepository;
    private PublisherRepository publisherRepository;

    public GameCommandToGame(DeveloperRepository developerRepository, PublisherRepository publisherRepository) {
        this.developerRepository = developerRepository;
        this.publisherRepository = publisherRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public Game convert (GameCommand source) {
        if (source == null) {
            return null;
        }

        final Game game = new Game();
        game.setId(source.getId()); // I don't know why, but something won't read you functions from other classes.
        game.setTitle(source.getTitle());
    }
}
