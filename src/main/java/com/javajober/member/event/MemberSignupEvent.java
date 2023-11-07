package com.javajober.member.event;

import com.javajober.member.domain.Member;
import com.javajober.space.dto.request.SpaceSaveRequest;

import lombok.Getter;

@Getter
public class MemberSignupEvent {

	private final Member member;
	private final SpaceSaveRequest personalSpaceRequest;
	private final SpaceSaveRequest organizationSpaceRequest;

	public MemberSignupEvent(
		final Member member, final SpaceSaveRequest personalSpaceRequest,
		final SpaceSaveRequest organizationSpaceRequest
	) {
		this.member = member;
		this.personalSpaceRequest = personalSpaceRequest;
		this.organizationSpaceRequest = organizationSpaceRequest;
	}
}
