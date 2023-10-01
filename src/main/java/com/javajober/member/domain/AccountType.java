package com.javajober.member.domain;

import lombok.Getter;

@Getter
public enum AccountType {

    PERSONAL("개인"),
    ENTERPRISE("기업");

    private final String description;

    AccountType(final String description) {
        this.description = description;
    }
}