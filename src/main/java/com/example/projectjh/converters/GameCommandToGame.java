package com.example.projectjh.converters;

import com.example.projectjh.commands.GameCommand;
import com.example.projectjh.model.Game;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameCommandToGame implements Converter<GameCommand, Game> {
    @Synchronized
    @Nullable
    @Override
    public Game convert (GameCommand source) {
        if (source == null) {
            return null;
        }
        final Game game = new Game();
        game.setTitle(source.getTitle());
        game.setGenre(source.getGenre());
        game.setYear(source.getYear());

        return game;
    }
}
