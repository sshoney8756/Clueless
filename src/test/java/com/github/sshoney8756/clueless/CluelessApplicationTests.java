package com.github.sshoney8756.clueless;

import com.github.sshoney8756.clueless.Domain.Game;
import com.github.sshoney8756.clueless.Repository.GameRepository;
import com.github.sshoney8756.clueless.common.GameStatus;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;


@SpringBootTest
@Slf4j
class CluelessApplicationTests {

    @Autowired
    GameRepository gameRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testGame() {
        Game game = new Game();
        game.setStatus(GameStatus.CREATED);
        game.setCluePoint(1);
        game.setCurrentRound(1);
        game.setFinalScore(1);
        game.setStartedAt(LocalDateTime.now());

        Game found = gameRepository.save(game);
        Assertions.assertThat(found.getId()).isEqualTo(game.getId());
    }

}
