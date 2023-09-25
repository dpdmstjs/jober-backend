package com.javajober.snsBlock.dto;

import com.javajober.snsBlock.domain.SNSBlock;
import com.javajober.snsBlock.domain.SNSType;

import lombok.Getter;

@Getter
public class SNSBlockRequest {

	private String snsUUID;
	private SNSType snsType;
	private String snsURL;

	private SNSBlockRequest() {

	}

	public static SNSBlock toEntity(final SNSBlockRequest snsBlockRequest) {
		return SNSBlock.builder()
			.snsUUID(snsBlockRequest.getSnsUUID())
			.snsType(snsBlockRequest.getSnsType())
			.snsURL(snsBlockRequest.getSnsURL())
			.build();
	}
}