package com.javajober.snsBlock.domain;

import lombok.Getter;

@Getter
public enum SNSType {

    INSTAGRAM("인스타그램"),
    FACEBOOK("페이스북"),
    LINKEDIN("링크드인"),
    BEHANCE("비핸스");

    private final String title;

    SNSType(final String title) {
        this.title = title;
    }
}

