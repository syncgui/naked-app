package com.glipe.nakedappserver.service;

import com.glipe.nakedappserver.model.PlayerGoal;
import com.glipe.nakedappserver.model.dto.PlayerGoalDTO;
import com.glipe.nakedappserver.model.mapper.DocumentMapper;
import com.glipe.nakedappserver.repository.PlayerGoalRepository;
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