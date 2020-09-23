package com.example.projectjh.repositories;

import com.example.projectjh.model.Developer;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface DeveloperRepository extends CrudRepository<Developer, Long>{
    Optional<Developer> getDeveloperByName(String Name);
}
