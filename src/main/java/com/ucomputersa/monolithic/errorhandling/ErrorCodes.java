package com.ucomputersa.monolithic.errorhandling;

public class ErrorCodes {

    public static final ErrorDetail EXCEPTION = new ErrorDetail(9999, "Please Contact Admin");

    public static final ErrorDetail PASSWORD_NOT_MATCH = new ErrorDetail(1001, "Password doesn't match");

    public static final ErrorDetail USER_NOT_FOUND = new ErrorDetail(1002, "USER_NOT_FOUND");




    public record ErrorDetail(int code, String message) {
    }



}
