package com.PL.PremierZone.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepositary extends JpaRepository<Player, String> {

    void deleteByName(String playerName);

    Optional<Player> findByName(String name);

}


