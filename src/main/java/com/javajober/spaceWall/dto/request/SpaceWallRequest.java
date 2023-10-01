package com.javajober.spaceWall.dto.request;

import com.javajober.entity.AddSpace;
import com.javajober.member.domain.Member;
import com.javajober.spaceWall.domain.FlagType;
import com.javajober.spaceWall.domain.SpaceWall;
import com.javajober.spaceWall.domain.SpaceWallCategoryType;

import lombok.Getter;

@Getter
public class SpaceWallRequest {
    private DataRequest data;

    private SpaceWallRequest() {

    }

    public SpaceWallRequest(final DataRequest data) {
        this.data = data;
    }

    public static SpaceWall toEntity(SpaceWallCategoryType category, Member member, AddSpace addSpace, String shareURL, FlagType flagType, String blocks) {
        return SpaceWall.builder()
            .spaceWallCategoryType(category)
            .member(member)
            .addSpace(addSpace)
            .shareURL(shareURL)
            .flag(flagType)
            .blocks(blocks)
            .build();
    }
}
