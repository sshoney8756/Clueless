package com.github.sshoney8756.clueless.Domain;

import com.github.sshoney8756.clueless.common.GameStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus status;

    @Column(nullable = false)
    private int cluePoint;

    @Column(nullable = false)
    private int currentRound;

    private int finalScore;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startedAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endedAt;

    public Game(GameStatus status, int cluePoint, int currentRound, LocalDateTime startedAt ) {
        this.status = status;
        this.cluePoint = cluePoint;
        this.currentRound = currentRound;
        this.startedAt = startedAt;
    }
}
