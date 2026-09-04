package com.PL.PremierZone.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="player/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService1){
        this.playerService = playerService1;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

        if (team != null && name != null) {
            return playerService.getPlayersByTeamAndName(team, name);
        }

        if (team != null && position != null) {
            return playerService.getPlayersByTeamandPosition(team, position);
        }

        if (team != null) {
            return playerService.getPlayersByTeamName(team);
        }

        if (name != null) {
            return playerService.getPlayersByName(name);
        }

        if (position != null) {
            return playerService.getPlayerByPosition(position);
        }

        if (nation != null) {
            return playerService.getPlayersBYNation(nation);
        }

        return playerService.getPlayers();
    }
}
