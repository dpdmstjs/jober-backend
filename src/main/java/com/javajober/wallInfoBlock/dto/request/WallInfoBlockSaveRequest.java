package com.javajober.wallInfoBlock.dto.request;

import com.javajober.wallInfoBlock.domain.WallInfoBlock;

import lombok.Getter;

@Getter
public class WallInfoBlockSaveRequest {

	private String wallInfoTitle;
	private String wallInfoDescription;

	private WallInfoBlockSaveRequest() {

	}

	public WallInfoBlockSaveRequest(final String wallInfoTitle, final String wallInfoDescription) {
		this.wallInfoTitle = wallInfoTitle;
		this.wallInfoDescription = wallInfoDescription;
	}

	public static WallInfoBlock toEntity(final WallInfoBlockSaveRequest wallInfoBlock) {
		return WallInfoBlock.builder()
				.wallInfoTitle(wallInfoBlock.getWallInfoTitle())
				.wallInfoDescription(wallInfoBlock.getWallInfoDescription())
				.build();
	}
}
