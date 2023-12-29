package com.glipe.nakedappserver.model;


import lombok.Data;
import org.bson.Document;

@Data
public class PlayerInfo extends Document {
    private String playerID;
    private String name;
    private int age;
    private String contactPhone;
    private Double rating = null;
}
