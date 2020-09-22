package com.example.projectjh.tools;

import com.example.projectjh.model.Developer;
import com.example.projectjh.model.Publisher;
import com.example.projectjh.model.Game;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.example.projectjh.repositories.DeveloperRepository;
import com.example.projectjh.repositories.PublisherRepository;
import com.example.projectjh.repositories.GameRepository;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(GameRepository gameRepository, DeveloperRepository developerRepository, PublisherRepository publisherRepository){
        this.gameRepository = gameRepository;
        this.developerRepository = developerRepository;
        this.publisherRepository = publisherRepository;
    }

    private GameRepository gameRepository;
    private DeveloperRepository developerRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){ initData(); }
       private void initData(){

        Developer iD = new Developer("id Software", "1991", "USA", "Richardson, Texas");
        Publisher GT = new Publisher("GT Interactive");
        Game Quake = new Game ("Quake", "First Person Shooter", "1996", GT);
        publisherRepository.save(GT);
        developerRepository.save(iD);
        gameRepository.save(Quake);

        Developer valve = new Developer("Valve Corporation", "1996", "USA", "Bellevue, Washington");
        Publisher sierra = new Publisher("Sierra Studios, Valve (digital)");
        Game hl1 = new Game ("Half-Life", "First Person Shooter", "1998", sierra);
        publisherRepository.save(sierra);
        developerRepository.save(valve);
        gameRepository.save(hl1);

        Developer dma = new Developer("Rockstar North (formerly DMA Design Ltd.)", "1987", "Scotland", "Edinburgh");
        Publisher rockstar = new Publisher("Rockstar Games");
        Game gta3 = new Game ("Grand Theft Auto III", "Action-adventure", "2001", rockstar);
        publisherRepository.save(rockstar);
        developerRepository.save(dma);
        gameRepository.save(gta3);

    }

}
