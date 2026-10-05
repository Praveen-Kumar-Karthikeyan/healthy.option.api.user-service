package com.healthy.option.api.user_service.domain;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HttpResponse {

    private int httpStatusCode; // Http Status Code
    private HttpStatus httpStatus; // Http Status with Http Message
    private String reason; // Http Reason from Enum
    private String message;
    private String timeStamp;

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
        this.timeStamp = LocalDateTime.now().toString();
    }
}
