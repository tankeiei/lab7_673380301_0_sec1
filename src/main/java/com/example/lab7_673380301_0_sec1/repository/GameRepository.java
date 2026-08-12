package com.example.lab7_673380301_0_sec1.repository;

import com.example.lab7_673380301_0_sec1.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
