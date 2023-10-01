package com.javajober.snsBlock.dto.request;

import java.util.List;

import lombok.Getter;

@Getter
public class SNSBlockSaveRequests<T> {

	List<T> subData;

	private SNSBlockSaveRequests() {

	}

	public SNSBlockSaveRequests(List<T> subData) {
		this.subData = subData;
	}
}