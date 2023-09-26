package com.javajober.snsBlock.dto;

import com.javajober.snsBlock.domain.SNSBlock;
import com.javajober.snsBlock.domain.SNSType;

import lombok.Getter;

@Getter
public class SNSBlockUpdateRequest {

	private Long snsId;
	private String snsUUID;
	private String snsType;
	private String snsURL;

	private SNSBlockUpdateRequest() {

	}
}
