package com.glipe.nakedappserver.model;


import lombok.Data;

@Data
public class PlayerInfo {
    private String playerID;
    private String name;
    private String age;
    private String contactPhone;
    private Double rating = null;
}
