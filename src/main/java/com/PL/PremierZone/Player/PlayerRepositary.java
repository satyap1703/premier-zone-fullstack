package com.PL.PremierZone.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepositary extends JpaRepository<Player, String> {

    void deleteByName(String playerName);

    Optional<Player> findByName(String name);

    List<Player>findByTeam(String Team);
    List<Player>findByNameContainingIgnoreCase(String name);
    List<Player>findByTeamIgnoreCaseAndNameContainingIgnoreCase(
            String team,
            String name

    );

}


