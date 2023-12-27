package com.glipe.nakedappserver.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.glipe.nakedappserver.model.PlayerInfo;
import com.glipe.nakedappserver.service.PlayerInfoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerInfoResource {
    private final PlayerInfoService service;

    @PostConstruct
    public PlayerInfo createPlayerInformation(PlayerInfo dto) throws JsonProcessingException {
        return service.createPlayerInfo(dto);
    }
}
