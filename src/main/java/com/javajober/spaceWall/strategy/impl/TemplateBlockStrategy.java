package com.javajober.spaceWall.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javajober.blocks.templateBlock.domain.TemplateBlock;
import com.javajober.blocks.templateBlock.dto.request.TemplateBlockSaveRequest;
import com.javajober.blocks.templateBlock.repository.TemplateBlockRepository;
import com.javajober.spaceWall.strategy.BlockJsonHandler;
import com.javajober.spaceWall.strategy.BlockStrategyName;
import com.javajober.spaceWall.strategy.MoveBlockStrategy;


@Component
public class TemplateBlockStrategy implements MoveBlockStrategy {

	private final BlockJsonHandler blockJsonHandler;
	private final TemplateBlockRepository templateBlockRepository;

	public TemplateBlockStrategy(final BlockJsonHandler blockJsonHandler, final TemplateBlockRepository templateBlockRepository) {
		this.blockJsonHandler = blockJsonHandler;
		this.templateBlockRepository = templateBlockRepository;
	}


	@Override
	public List<Long> saveBlocks(final List<Object> subData) {
		List<Long> templateBlockIds = new ArrayList<>();

		subData.forEach(block -> {
			TemplateBlockSaveRequest request = blockJsonHandler.convertValue(block, TemplateBlockSaveRequest.class);
			TemplateBlock templateBlock = TemplateBlockSaveRequest.toEntity(request);
			templateBlockIds.add(templateBlockRepository.save(templateBlock).getId());
		});

		return templateBlockIds;
	}

	@Override
	public String getStrategyName() {
		return BlockStrategyName.TemplateBlockStrategy.name();
	}
}
