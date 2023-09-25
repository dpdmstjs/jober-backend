package com.javajober.snsBlock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javajober.snsBlock.domain.SNSBlock;
import com.javajober.snsBlock.dto.SNSBlockRequest;
import com.javajober.snsBlock.dto.SNSBlockRequests;
import com.javajober.snsBlock.repository.SNSBlockRepository;

@Service
public class SNSBlockService {

	private final SNSBlockRepository snsBlockRepository;

	public SNSBlockService(SNSBlockRepository snsBlockRepository) {
		this.snsBlockRepository = snsBlockRepository;
	}

	@Transactional
	public void save(final SNSBlockRequests<SNSBlockRequest> snsBlockRequests) {
		snsBlockRequests.getSubData().forEach(snsBlockrequest -> {
			SNSBlock snsBlock = SNSBlockRequest.toEntity(snsBlockrequest);
			snsBlockRepository.save(snsBlock);
		});
	}
}