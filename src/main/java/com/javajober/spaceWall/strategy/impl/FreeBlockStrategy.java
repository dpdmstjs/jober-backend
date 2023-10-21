package com.javajober.spaceWall.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javajober.blocks.freeBlock.domain.FreeBlock;
import com.javajober.blocks.freeBlock.dto.request.FreeBlockSaveRequest;
import com.javajober.blocks.freeBlock.repository.FreeBlockRepository;
import com.javajober.spaceWall.strategy.BlockJsonHandler;
import com.javajober.spaceWall.strategy.BlockStrategyName;
import com.javajober.spaceWall.strategy.MoveBlockStrategy;

@Component
public class FreeBlockStrategy implements MoveBlockStrategy {
	private final BlockJsonHandler blockJsonHandler;
	private final FreeBlockRepository freeBlockRepository;

	public FreeBlockStrategy(final BlockJsonHandler blockJsonHandler, final FreeBlockRepository freeBlockRepository) {
		this.blockJsonHandler = blockJsonHandler;
		this.freeBlockRepository = freeBlockRepository;
	}

	@Override
	public List<Long> saveBlocks(final List<Object> subData) {

		List<Long> freeBlockIds = new ArrayList<>();

		subData.forEach(block -> {
			FreeBlockSaveRequest request = blockJsonHandler.convertValue(block, FreeBlockSaveRequest.class);
			FreeBlock freeBlock = FreeBlockSaveRequest.toEntity(request);
			freeBlockIds.add(freeBlockRepository.save(freeBlock).getId());
		});

		return freeBlockIds;
	}

	@Override
	public String getStrategyName() {
		return BlockStrategyName.FreeBlockStrategy.name();
	}
}
