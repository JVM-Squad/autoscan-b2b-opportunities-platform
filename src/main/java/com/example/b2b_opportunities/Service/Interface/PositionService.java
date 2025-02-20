package com.example.b2b_opportunities.Service.Interface;

import com.example.b2b_opportunities.Dto.Request.PositionEditRequestDto;
import com.example.b2b_opportunities.Dto.Request.PositionRequestDto;
import com.example.b2b_opportunities.Dto.Response.PositionResponseDto;
import com.example.b2b_opportunities.Entity.Position;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface PositionService {
    PositionResponseDto createPosition(PositionRequestDto dto, Authentication authentication);

    PositionResponseDto editPosition(Long id, PositionEditRequestDto dto, Authentication authentication);

    void deletePosition(Long id, Authentication authentication);

    PositionResponseDto getPosition(Authentication authentication, Long id);

    Set<PositionResponseDto> getPositions(Authentication authentication);

    void editPositionStatus(Long positionId, Long statusId, String customCloseReason, Authentication authentication);

    Position getPositionOrThrow(Long id);
}
