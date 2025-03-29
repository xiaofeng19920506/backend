package com.ucomputersa.monolithic.constant;

public enum ReservationStatus {

    PENDING(0, "pending"),

    IN_PROGRESS(1, "in progress"),

    COMPLETED(2, "completed"),
    CANCELED(3, "canceled");

    private final int code;
    private final String msg;

    ReservationStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
