package com.github.sshoney8756.clueless.Domain;

import com.github.sshoney8756.clueless.common.GameStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Game {

    @Id @GeneratedValue(generator = "uuid")
    private String id;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    private int cluePoint;
    private int currentRound;
    private int finalScore;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startedAt;

    @Column(columnDefinition = "TIMESTAMP")
    @Nullable
    private LocalDateTime endedAt;

}
