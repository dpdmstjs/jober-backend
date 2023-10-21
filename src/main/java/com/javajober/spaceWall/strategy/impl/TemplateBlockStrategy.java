package com.javajober.spaceWall.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javajober.blocks.templateBlock.domain.TemplateBlock;
import com.javajober.blocks.templateBlock.dto.request.TemplateBlockSaveRequest;
import com.javajober.blocks.templateBlock.repository.TemplateBlockRepository;
import com.javajober.spaceWall.strategy.BlockStrategyName;
import com.javajober.spaceWall.strategy.MoveBlockStrategy;


@Component
public class TemplateBlockStrategy implements MoveBlockStrategy {

	private final TemplateBlockRepository templateBlockRepository;

	public TemplateBlockStrategy(final TemplateBlockRepository templateBlockRepository) {
		this.templateBlockRepository = templateBlockRepository;
	}


	@Override
	public List<Long> saveBlocks(final List<Object> subData, final ObjectMapper objectMapper) {
		List<Long> templateBlockIds = new ArrayList<>();

		subData.forEach(block -> {
			TemplateBlockSaveRequest request = objectMapper.convertValue(block, TemplateBlockSaveRequest.class);
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
