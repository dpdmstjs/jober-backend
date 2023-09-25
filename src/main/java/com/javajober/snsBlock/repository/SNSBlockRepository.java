package com.javajober.snsBlock.repository;

import org.springframework.data.repository.Repository;

import com.javajober.snsBlock.domain.SNSBlock;

public interface SNSBlockRepository extends Repository<SNSBlock, Long> {
	SNSBlock save(SNSBlock snsBlock);
}
