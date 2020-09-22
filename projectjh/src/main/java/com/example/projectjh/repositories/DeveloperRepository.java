package com.example.projectjh.repositories;

import com.example.projectjh.model.Developer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeveloperRepository extends CrudRepository<Developer, Long>{
    Optional<Developer> getFirstByName(String Name);
}
