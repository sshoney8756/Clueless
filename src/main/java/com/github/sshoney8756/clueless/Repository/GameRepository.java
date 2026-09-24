package com.github.sshoney8756.clueless.Repository;

import com.github.sshoney8756.clueless.Domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, String> {

}
