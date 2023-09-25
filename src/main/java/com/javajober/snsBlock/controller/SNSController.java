package com.javajober.snsBlock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javajober.core.message.SuccessMessage;
import com.javajober.core.util.ApiUtils;
import com.javajober.snsBlock.dto.SNSBlockRequest;
import com.javajober.snsBlock.dto.SNSBlockRequests;
import com.javajober.snsBlock.service.SNSBlockService;

@RequestMapping("/api/wall/sns")
@RestController
public class SNSController {

	private final SNSBlockService snsBlockService;

	public SNSController(final SNSBlockService snsBlockService) {
		this.snsBlockService = snsBlockService;
	}

	@PostMapping("/")
	public ResponseEntity<ApiUtils.ApiResponse> save(@RequestBody final SNSBlockRequests<SNSBlockRequest> snsBlockRequests) {
		snsBlockService.save(snsBlockRequests);
		return ResponseEntity.ok(ApiUtils.success(HttpStatus.CREATED, SuccessMessage.CREATE_SUCCESS, null));
	}
}