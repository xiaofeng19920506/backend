package com.ucomputersa.monolithic.constant;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum UserStatus {
    ACTIVE,
    INACTIVE,
    BLOCKED;
}
