package com.javajober.snsBlock.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SNSBlockRequests {

	List<SNSBlockRequest> snsBlocks;

	private SNSBlockRequests() {

	}

	public SNSBlockRequests(final List<SNSBlockRequest> snsBlocks) {
		this.snsBlocks = snsBlocks;
	}
}
