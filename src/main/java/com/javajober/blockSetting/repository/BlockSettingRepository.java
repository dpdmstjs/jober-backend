package com.javajober.blockSetting.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.javajober.blockSetting.domain.BlockSetting;
import com.javajober.exception.ApiStatus;
import com.javajober.exception.ApplicationException;

public interface BlockSettingRepository extends Repository<BlockSetting, Long> {

	BlockSetting save(final BlockSetting blockSetting);

	Optional<BlockSetting> findById(final Long id);

	default BlockSetting getById (final Long id) {
		return findById(id)
			.orElseThrow(() -> new ApplicationException(ApiStatus.NOT_FOUND, "블록 설정 데이터를 찾을 수 없습니다."));
	}
}