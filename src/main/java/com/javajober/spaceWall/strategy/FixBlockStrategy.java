package com.javajober.spaceWall.strategy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.javajober.core.util.response.CommonResponse;
import com.javajober.spaceWall.dto.request.DataStringSaveRequest;

import java.util.List;

public interface FixBlockStrategy {
	void saveBlocks(final DataStringSaveRequest data, ArrayNode blockInfoArray, Long position);

	CommonResponse createFixBlockDTO(List<JsonNode> fixBlocks);

	String getStrategyName();
}
