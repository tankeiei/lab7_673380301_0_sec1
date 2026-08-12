package com.example.lab7_673380301_0_sec1.service;

import com.example.lab7_673380301_0_sec1.model.Game;
import com.example.lab7_673380301_0_sec1.repository.GameRepository;
import com.example.lab7_673380301_0_sec1.strategy.DiscountContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    // Constructor Injection
    public GameService(GameRepository gameRepository, DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        for (Game game : games) {
            discountContext.applyDiscount(game);
        }
        return games;
    }

    public Game getGameById(Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            discountContext.applyDiscount(game);
            return game;
        }
        return null;
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }
}
