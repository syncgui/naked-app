package com.glipe.playersinfoserver.model.mapper;

import com.glipe.playersinfoserver.model.PlayerGoal;
import com.glipe.playersinfoserver.model.PlayerInfo;
import com.glipe.playersinfoserver.model.dto.PlayerGoalDTO;
import com.glipe.playersinfoserver.model.dto.PlayerInfoDTO;

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