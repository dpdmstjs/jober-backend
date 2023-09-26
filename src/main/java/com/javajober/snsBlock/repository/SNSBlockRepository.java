package com.javajober.snsBlock.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.javajober.snsBlock.domain.SNSBlock;

public interface SNSBlockRepository extends Repository<SNSBlock, Long> {
	SNSBlock save(SNSBlock snsBlock);
	List<SNSBlock> findAllById(List<Long> id);
}
