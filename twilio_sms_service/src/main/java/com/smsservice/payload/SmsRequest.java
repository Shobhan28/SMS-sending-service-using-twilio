package com.smsservice.payload;

import lombok.Data;

@Data
public class SmsRequest {

    private String to;
    private String message;

    public String getTo() {
        return to;
    }
}
