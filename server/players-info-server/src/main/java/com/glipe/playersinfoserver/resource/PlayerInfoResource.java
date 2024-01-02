package com.glipe.playersinfoserver.resource;

import com.glipe.playersinfoserver.model.PlayerInfo;
import com.glipe.playersinfoserver.model.dto.PlayerInfoDTO;
import com.glipe.playersinfoserver.service.PlayerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerInfoResource {

    private final PlayerInfoService service;

    @PostMapping
    public PlayerInfo createPlayerInformation(@RequestBody PlayerInfoDTO dto){
        return service.createPlayerInfo(dto);
    }
}