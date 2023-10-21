package com.javajober.spaceWall.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javajober.blocks.listBlock.domain.ListBlock;
import com.javajober.blocks.listBlock.dto.request.ListBlockSaveRequest;
import com.javajober.blocks.listBlock.repository.ListBlockRepository;
import com.javajober.spaceWall.strategy.BlockStrategyName;
import com.javajober.spaceWall.strategy.MoveBlockStrategy;

@Component
public class ListBlockStrategy implements MoveBlockStrategy {

	private final ListBlockRepository listBlockRepository;


	public ListBlockStrategy(final ListBlockRepository listBlockRepository) {
		this.listBlockRepository = listBlockRepository;
	}


	@Override
	public List<Long> saveBlocks(final List<Object> subData, final ObjectMapper objectMapper) {

		List<Long> listBlockIds = new ArrayList<>();

		subData.forEach(block -> {
			ListBlockSaveRequest request = objectMapper.convertValue(block, ListBlockSaveRequest.class);
			ListBlock listBlock = ListBlockSaveRequest.toEntity(request);
			listBlockIds.add(listBlockRepository.save(listBlock).getId());
		});

		return listBlockIds;
	}

	@Override
	public String getStrategyName() {
		return BlockStrategyName.ListBlockStrategy.name();
	}
}
