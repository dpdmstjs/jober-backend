package com.javajober.snsBlock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.javajober.exception.ApiStatus;
import com.javajober.exception.ApplicationException;
import com.javajober.snsBlock.domain.SNSBlock;

public interface SNSBlockRepository extends Repository<SNSBlock, Long> {

	SNSBlock save(final SNSBlock snsBlock);

	List<SNSBlock> saveAll(final Iterable<SNSBlock> snsBlock);

	List<SNSBlock> findAllById(final Iterable<Long> id);

	Optional<SNSBlock> findById(final Long id);

	default SNSBlock findSNSBlock(final Long id) {
		return findById(id)
			.orElseThrow(() -> new ApplicationException(ApiStatus.NOT_FOUND, "SNS 블록 데이터를 찾을 수 없습니다."));
	}
}