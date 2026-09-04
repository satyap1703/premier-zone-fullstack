package com.PL.PremierZone.Player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @InjectMocks
    PlayerService playerService;

    @Mock
    PlayerRepositary playerRepositary;

    @Test
    void playersNameShouldGetByName () {
        Player player = new Player();
        System.out.println("first test");
        Mockito.when(playerRepositary.findAll()).thenReturn(java.util.List.of(player));
         java.util.List<Player> players = playerService.getPlayers();
         assertEquals(1,players.size());






    }


}