package com.sabir.rest.webservices.restfull_web_services.user.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {


    private LocalDateTime localDateTime;
    private String message;
    private String detais;

    public ErrorDetails(LocalDateTime localDateTime, String message, String detais) {
        super();
        this.localDateTime = localDateTime;
        this.message = message;
        this.detais = detais;
    }

    public LocalDateTime getTimeStamp() {
        return localDateTime;
    }

    public String getMessage() {
        return message;
    }
    public String getDetais() {
        return detais;
    }


}
