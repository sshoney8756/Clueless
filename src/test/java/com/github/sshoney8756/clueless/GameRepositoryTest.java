package com.github.sshoney8756.clueless;

import static org.junit.jupiter.api.Assertions.*;

import com.github.sshoney8756.clueless.Domain.Game;
import com.github.sshoney8756.clueless.Repository.GameRepository;
import com.github.sshoney8756.clueless.common.GameStatus;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")

class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Test
    @DisplayName("게임 저장")
    @Rollback(value = false)
    @Transactional
    public void insertGame() {
        Game game = new Game(GameStatus.CREATED, 30, 1, LocalDateTime.now());
        Game savedGame = gameRepository.save(game);
        Game found = gameRepository.findById(game.getId()).orElseThrow();
        assertEquals(savedGame, found);
    }

}
