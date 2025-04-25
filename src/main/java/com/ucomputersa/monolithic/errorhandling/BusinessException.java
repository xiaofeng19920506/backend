package com.ucomputersa.monolithic.errorhandling;

public final class BusinessException extends RuntimeException {
    private final ErrorCodes.ErrorDetail errorDetail;

    public BusinessException(ErrorCodes.ErrorDetail errorDetail) {
        super(errorDetail.message());
        this.errorDetail = errorDetail;
    }

    public int getCode() {
        return errorDetail.code();
    }

    public String getMessage() {
        return errorDetail.message();
    }
}