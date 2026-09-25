package com.github.sshoney8756.clueless.Domain;

import com.github.sshoney8756.clueless.common.GameRoundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class GameRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int round;

    @Column(nullable = false)
    private GameRoundStatus status;

    @Column(nullable = false)
    private int imageRevealLevel;

    @Column(nullable = false)
    private int answerAttempt;

    @Column(nullable = false)
    private int cluePointSpent;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startedAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public GameRound(int round, GameRoundStatus status, int imageRevealLevel, int answerAttempt, int cluePointSpent, LocalDateTime startedAt, Game game) {
        this.round = round;
        this.status = status;
        this.imageRevealLevel = imageRevealLevel;
        this.answerAttempt = answerAttempt;
        this.cluePointSpent = cluePointSpent;
        this.startedAt = startedAt;
        this.game = game;
    }
}
