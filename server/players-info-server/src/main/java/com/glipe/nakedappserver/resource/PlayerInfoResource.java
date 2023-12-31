package com.glipe.nakedappserver.resource;

import com.glipe.nakedappserver.model.PlayerInfo;
import com.glipe.nakedappserver.model.dto.PlayerInfoDTO;
import com.glipe.nakedappserver.service.PlayerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerInfoResource {
    private final PlayerInfoService service;

    @PostMapping
    public PlayerInfo createPlayerInformation(@RequestBody PlayerInfoDTO dto){
        return service.createPlayerInfo(dto);
    }
}
