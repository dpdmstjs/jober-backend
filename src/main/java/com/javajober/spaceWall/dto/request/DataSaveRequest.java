package com.javajober.spaceWall.dto.request;

import java.util.List;

import com.javajober.styleSetting.dto.request.StyleSettingSaveRequest;
import com.javajober.wallInfoBlock.dto.request.WallInfoBlockSaveRequest;
import lombok.Getter;

@Getter
public class DataSaveRequest {
	private String category;
	private Long memberId;
	private Long addSpaceId;
	private String shareURL;
	private WallInfoBlockSaveRequest wallInfoBlock;
	private List<BlockSaveRequest> blocks;
	private StyleSettingSaveRequest styleSetting;
  
	private DataSaveRequest() {
	}

	public DataSaveRequest(final String category, final Long memberId, Long addSpaceId, final String shareURL, final WallInfoBlockSaveRequest wallInfoBlock, final List<BlockSaveRequest> blocks, final StyleSettingSaveRequest styleSetting) {
		this.category = category;
		this.memberId = memberId;
		this.addSpaceId = addSpaceId;
		this.shareURL = shareURL;
		this.wallInfoBlock = wallInfoBlock;
		this.blocks = blocks;
		this.styleSetting = styleSetting;
	}
}