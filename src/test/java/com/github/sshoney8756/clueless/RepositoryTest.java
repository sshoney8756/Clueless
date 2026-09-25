package com.github.sshoney8756.clueless;

import static org.junit.jupiter.api.Assertions.*;

import com.github.sshoney8756.clueless.Domain.Game;
import com.github.sshoney8756.clueless.Domain.GameRound;
import com.github.sshoney8756.clueless.Repository.GameRepository;
import com.github.sshoney8756.clueless.Repository.GameRoundRepository;
import com.github.sshoney8756.clueless.common.GameRoundStatus;
import com.github.sshoney8756.clueless.common.GameStatus;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class RepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameRoundRepository gameRoundRepository;

    @Test
    @DisplayName("게임 저장")
    @Transactional
    public void insertGame() {
        Game game = new Game(GameStatus.CREATED, 30, 1, LocalDateTime.now());
        Game savedGame = gameRepository.save(game);
        Game found = gameRepository.findById(game.getId()).orElseThrow();

        assertEquals(savedGame, found);
    }

    @Test
    @DisplayName("게임 라운드 저장")
    @Transactional
    public void insertGameRound() {
        Game game = new Game(GameStatus.CREATED, 30, 1, LocalDateTime.now());
        Game savedGame = gameRepository.save(game);
        GameRound round = new GameRound(1, GameRoundStatus.CREATED, 1, 1, 5, LocalDateTime.now(), game);
        GameRound savedRound = gameRoundRepository.save(round);

        GameRound found = gameRoundRepository.findById(savedRound.getId()).orElseThrow();
        assertEquals(found.getGame(), savedGame);
    }
}
