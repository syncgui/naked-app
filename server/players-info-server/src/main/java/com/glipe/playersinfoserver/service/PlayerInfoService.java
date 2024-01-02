package com.glipe.playersinfoserver.service;

import com.glipe.playersinfoserver.model.dto.PlayerInfoDTO;
import com.glipe.playersinfoserver.model.mapper.DocumentMapper;
import com.glipe.playersinfoserver.util.AvailableLetters;
import com.glipe.playersinfoserver.model.PlayerInfo;
import com.glipe.playersinfoserver.repository.PersonalIDRepository;
import com.glipe.playersinfoserver.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class PlayerInfoService {

    private final PlayerRepository playerRepository;
    private final PersonalIDRepository personalIDRepository;
    private final String[] availableLetters = AvailableLetters.availableLetters;

    public PlayerInfo createPlayerInfo(PlayerInfoDTO dto){
        String generatedID = randomPlayerID();
        dto.setPlayerID(generatedID);
        PlayerInfo playerInfo = DocumentMapper.buildDocument(dto);
        if(!playerRepository.insertPlayer(playerInfo)){
            throw new RuntimeException();
        }

        changeIdAvailability(generatedID);

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
       personalIDRepository.changeIdAvailability(id);
    }
}
