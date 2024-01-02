package com.glipe.playersinfoserver.service;

import com.glipe.playersinfoserver.model.PlayerGoal;
import com.glipe.playersinfoserver.model.mapper.DocumentMapper;
import com.glipe.playersinfoserver.repository.PlayerGoalRepository;
import com.glipe.playersinfoserver.model.dto.PlayerGoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerGoalService {

    private final PlayerGoalRepository playerGoalRepository;

    public PlayerGoal createPlayerGoal(PlayerGoalDTO dto) {
        PlayerGoal playerGoal = DocumentMapper.buildDocument(dto);
        if (!playerGoalRepository.insertGoal(playerGoal)) {
            throw new RuntimeException();
        }

        return playerGoal;
    }
}