package com.glipe.nakedappserver.model.mapper;

import com.glipe.nakedappserver.model.PlayerGoal;
import com.glipe.nakedappserver.model.PlayerInfo;
import com.glipe.nakedappserver.model.dto.PlayerGoalDTO;
import com.glipe.nakedappserver.model.dto.PlayerInfoDTO;

public class DocumentMapper {
     public static PlayerGoal buildDocument(PlayerGoalDTO dto) {
         PlayerGoal playerGoal = new PlayerGoal();
         playerGoal.put("goal_player_id", dto.getGoalPlayerID());
         playerGoal.put("assist_player_id", dto.getAssistPlayerID());
         playerGoal.put("created_at", dto.getCreatedAt());
         return playerGoal;
    }

    public static PlayerInfo buildDocument(PlayerInfoDTO dto) {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.put("name", dto.getName());
        playerInfo.put("age", dto.getAge());
        playerInfo.put("contact_phone", dto.getContactPhone());
        playerInfo.put("personal_id", dto.getPlayerID());
        return playerInfo;
    }
}