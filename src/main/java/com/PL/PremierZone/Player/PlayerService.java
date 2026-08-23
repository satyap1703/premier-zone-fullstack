package com.PL.PremierZone.Player;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepositary playerRepositary;

    @Autowired
    public PlayerService(PlayerRepositary playerRepositary1){
        this.playerRepositary = playerRepositary1;
    }
    public  List<Player> getPlayers(){
        return playerRepositary.findAll();

    }

    public List<Player> getPlayersByTeamName(String TeamName){
        return playerRepositary.findAll().stream()
                .filter(player -> TeamName.equals(player.getTeam()))
                .collect(Collectors.toList());

    }
    public List<Player> getPlayersByName(String name){
        return playerRepositary.findAll().stream()
                .filter(player -> name.equals(player.getName().toLowerCase().contains(name.toLowerCase())))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayerByPosition(String pos){
        return playerRepositary.findAll().stream()
                .filter(player -> (player.getPos().toLowerCase()).contains(pos.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersBYNation(String Nation){
        return playerRepositary.findAll().stream()
                .filter(player -> (player.getNation().toLowerCase().contains(Nation.toLowerCase())))
                .collect(Collectors.toList());

    }

    public List<Player> getPlayersByTeamandPosition(String Team , String Position){
        return playerRepositary.findAll().stream()
                .filter(player ->(Team.equals(player.getTeam()) && Position.equals(player.getPos())))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepositary.save(player);
        return player;

    }

    public Player updatePlayer(Player player) {

        Optional<Player> existingPlayer =
                playerRepositary.findByName(player.getName());

        if (existingPlayer.isPresent()) {

            Player playerToUpdate = existingPlayer.get();

            playerToUpdate.setName(player.getName());
            playerToUpdate.setTeam(player.getTeam());
            playerToUpdate.setPos(player.getPos());
            playerToUpdate.setAge(player.getAge());

            playerRepositary.save(playerToUpdate);
            return playerToUpdate;
        }

        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepositary.deleteByName(playerName);
    }




}
