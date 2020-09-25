package com.example.projectjh.repositories;

import com.example.projectjh.model.Developer;
import com.example.projectjh.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface GameRepository extends CrudRepository <Game,Long>{

    List<Game> getAllByDevelopersIsContaining(Developer developer);
    Optional<Game> getFirstByNip(String nip); // You can set whatever you want here.
}
