package com.javajober.entity;

import lombok.Getter;

@Getter
public enum SNSType {

    INSTAGRAM("인스타그램"),
    FACEBOOK("페이스북"),
    LINKEDIN("링크드인"),
    BEHANCE("비핸스");

    private final String description;

    private SNSType(final String description) {
        this.description = description;
    }
}

