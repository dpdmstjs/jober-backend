package com.javajober.member.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.javajober.space.service.SpaceService;

@Component
public class MemberSignupEventHandler {

	private final SpaceService spaceService;

	public MemberSignupEventHandler(final SpaceService spaceService) {
		this.spaceService = spaceService;
	}

	@EventListener(MemberSignupEvent.class)
	@Async("threadPoolTaskExecutor")
	public void handleMemberSignupEvent(final MemberSignupEvent event) {
		spaceService.initializeAndSaveNewMemberSpaces(event.getMember());
	}
}
