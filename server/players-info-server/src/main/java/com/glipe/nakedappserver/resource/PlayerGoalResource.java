package com.glipe.nakedappserver.resource;

import com.glipe.nakedappserver.model.PlayerGoal;
import com.glipe.nakedappserver.model.dto.PlayerGoalDTO;
import com.glipe.nakedappserver.service.PlayerGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
@RequiredArgsConstructor
public class PlayerGoalResource {

    private final PlayerGoalService service;

    @PostMapping
    public PlayerGoal createPlayerGoal(@RequestBody PlayerGoalDTO dto){
        return service.createPlayerGoal(dto);
    }
}