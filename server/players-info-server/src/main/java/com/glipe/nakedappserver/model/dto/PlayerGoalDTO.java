package com.glipe.nakedappserver.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlayerGoalDTO {
    private String goalPlayerID;
    private String assistPlayerID;
    private LocalDateTime createdAt = LocalDateTime.now();
}