package com.example.demo.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrorCode implements ErrorCode {

    BAD_REQUEST(400,"BAD_REQUEST","Bad Request"),
    METHOD_NOT_ALLOWED(405,"METHOD_NOT_ALLOWED","Method not Allowed"),
    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR","Internal Server Error");

    private final int status;
    private final String code;
    private final String message;
}
