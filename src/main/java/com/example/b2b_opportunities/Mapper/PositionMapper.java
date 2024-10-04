package com.example.b2b_opportunities.Mapper;

import com.example.b2b_opportunities.Dto.Request.PositionRequestDto;
import com.example.b2b_opportunities.Dto.Response.PositionResponseDto;
import com.example.b2b_opportunities.Entity.Position;
import com.example.b2b_opportunities.Entity.Skill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionMapper {
    public static Position toPosition(PositionRequestDto positionRequestDto) {
        return Position.builder()
                .isActive(positionRequestDto.isActive())
                .minYearsExperience(positionRequestDto.getMinYearsExperience())
                .hoursPerWeek(positionRequestDto.getHoursPerWeek())
                .responsibilities(positionRequestDto.getResponsibilities())
                .hiringProcess(positionRequestDto.getHiringProcess())
                .description(positionRequestDto.getDescription())
                .build();
    }

    public static PositionResponseDto toResponseDto(Position position) {
        List<String> workModeList = position.getWorkMode().stream().map(Enum::name).toList();
        List<Long> optionalSkillIds = position.getOptionalSkills().stream().map(Skill::getId).toList();

        return PositionResponseDto.builder()
                .id(position.getId())
                .projectId(position.getId())
                .role(position.getRole().getId())
                .isActive(position.isActive())
                .seniority(position.getSeniority().getLevel())
                .workMode(workModeList)
                .rate(RateMapper.toRateResponseDto(position.getRate()))
                .requiredSkills(RequiredSkillMapper.toRequiredSkillResponseDtoList(position.getRequiredSkills()))
                .optionalSkills(optionalSkillIds)
                .minYearsExperience(position.getMinYearsExperience())
                .hoursPerWeek(position.getHoursPerWeek())
                .responsibilities(position.getResponsibilities())
                .hiringProcess(position.getHiringProcess())
                .description(position.getDescription())
                .build();
    }
}