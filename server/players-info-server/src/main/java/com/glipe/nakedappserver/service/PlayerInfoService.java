package com.glipe.nakedappserver.service;

import com.glipe.nakedappserver.util.AvailableLetters;
import com.glipe.nakedappserver.model.PlayerInfo;
import com.glipe.nakedappserver.repository.PersonalIDRepository;
import com.glipe.nakedappserver.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;



@Service
@RequiredArgsConstructor
public class PlayerInfoService {

    private final PlayerRepository playerRepository;
    private final PersonalIDRepository personalIDRepository;
    private final String[] availableLetters = AvailableLetters.availableLetters;

    public PlayerInfo createPlayerInfo(PlayerInfo playerInfo){

        String generatedID = randomPlayerID();
        playerInfo.setPlayerID(generatedID);
        if(!playerRepository.insertPlayer(playerInfo)){
            throw new RuntimeException();
        }

        changeIdAvailability(playerInfo.getPlayerID());

        return playerInfo;

    }

    private String randomPlayerID() {
        var generatedId = generateNumberLetter();
        while (!isIdAvailable(generatedId)) {
            generatedId = generateNumberLetter();
        }
        return generatedId;
    }

    private String generateNumberLetter() {
        Random random = new Random();
        var alphabetIndex = random.nextInt(0, 25);
        var generatedNumber = random.nextInt(0, 9);
        String generatedLetter = availableLetters[alphabetIndex];

        var generatedId = new StringBuilder().append(generatedNumber).append(generatedLetter).toString();
        return generatedId;
    }

    private boolean isIdAvailable(String id) {
        return personalIDRepository.idAvailability(id);
    }



    private void changeIdAvailability(String id){
       //TODO
    }
}
