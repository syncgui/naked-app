package com.glipe.nakedappserver.model.mapper;

import com.glipe.nakedappserver.model.PlayerInfo;
import com.glipe.nakedappserver.model.dto.PlayerInfoDTO;

public class PlayerInfoMapper {
     public static PlayerInfo buildDocument(PlayerInfoDTO dto){
         PlayerInfo playerInfo = new PlayerInfo();
         playerInfo.put("name", dto.getName());
         playerInfo.put("age", dto.getAge());
         playerInfo.put("contact_phone", dto.getContactPhone());
         playerInfo.put("personal_id", dto.getPlayerID());
         return playerInfo;
    }
}
