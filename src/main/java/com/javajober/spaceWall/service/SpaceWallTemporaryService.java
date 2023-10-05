package com.javajober.spaceWall.service;

import com.javajober.core.error.exception.Exception404;
import com.javajober.core.message.ErrorMessage;
import com.javajober.spaceWall.domain.FlagType;
import com.javajober.spaceWall.domain.SpaceWall;
import com.javajober.spaceWall.dto.response.SpaceWallTemporaryResponse;
import com.javajober.spaceWall.repository.SpaceWallRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceWallTemporaryService {

    private final SpaceWallRepository spaceWallRepository;
    private final EntityManager entityManager;

    public SpaceWallTemporaryService(final SpaceWallRepository spaceWallRepository, final EntityManager entityManager){
        this.spaceWallRepository = spaceWallRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void delete(final Long memberId, final Long addSpaceId) {

        List<SpaceWall> spaceWalls = spaceWallRepository.findSpaceWallsOrThrow(memberId, addSpaceId);

        spaceWalls.forEach(spaceWall -> {
            if (spaceWall.getFlag().equals(FlagType.PENDING)) {
                entityManager.remove(spaceWall);
            }
        });
    }

    public SpaceWallTemporaryResponse hasSpaceWallTemporary(final Long memberId, final Long addSpaceId) {

        Optional<SpaceWall> spaceWall = spaceWallRepository.findByMemberIdAndAddSpaceIdAndFlag(memberId, addSpaceId, FlagType.PENDING);
        if (spaceWall.isPresent()) {
            Long spaceWallId = spaceWall.get().getId();
            return new SpaceWallTemporaryResponse(spaceWallId, true);
        }

        return new SpaceWallTemporaryResponse(null, false);
    }
}