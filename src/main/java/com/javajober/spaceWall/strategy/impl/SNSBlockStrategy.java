package com.javajober.spaceWall.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javajober.blocks.snsBlock.domain.SNSBlock;
import com.javajober.blocks.snsBlock.dto.request.SNSBlockSaveRequest;
import com.javajober.blocks.snsBlock.repository.SNSBlockRepository;
import com.javajober.spaceWall.strategy.BlockJsonHandler;
import com.javajober.spaceWall.strategy.BlockStrategyName;
import com.javajober.spaceWall.strategy.MoveBlockStrategy;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SNSBlockStrategy implements MoveBlockStrategy {

	private final BlockJsonHandler blockJsonHandler;
	private final SNSBlockRepository snsBlockRepository;

	public SNSBlockStrategy(final BlockJsonHandler blockJsonHandler, final SNSBlockRepository snsBlockRepository) {
		this.blockJsonHandler = blockJsonHandler;
		this.snsBlockRepository = snsBlockRepository;
	}

	@Override
	public List<Long> saveBlocks(final List<Object> subData) {
		List<Long> snsBlockIds = new ArrayList<>();

		subData.forEach(block -> {
			SNSBlockSaveRequest request = blockJsonHandler.convertValue(block, SNSBlockSaveRequest.class);
			SNSBlock snsBlock = SNSBlockSaveRequest.toEntity(request);
			snsBlockIds.add(snsBlockRepository.save(snsBlock).getId());
		});
		return snsBlockIds;
	}

	@Override
	public String getStrategyName() {
		return BlockStrategyName.SNSBlockStrategy.name();
	}
}
