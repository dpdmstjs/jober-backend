package com.javajober.spaceWall.strategy;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface MoveBlockStrategy {
	List<Long> saveBlocks(final List<Object> subData, final ObjectMapper objectMapper);

	String getStrategyName();
}

