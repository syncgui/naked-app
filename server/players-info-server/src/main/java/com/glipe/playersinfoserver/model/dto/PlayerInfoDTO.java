package com.glipe.playersinfoserver.model.dto;

import lombok.Data;

@Data
public class PlayerInfoDTO {
    private String playerID;
    private String name;
    private int age;
    private String contactPhone;
    private Double rating = null;
}