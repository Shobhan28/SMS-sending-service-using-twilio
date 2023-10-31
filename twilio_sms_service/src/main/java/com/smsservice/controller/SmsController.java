package com.smsservice.controller;

import com.smsservice.payload.SmsRequest;
import com.smsservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    private SmsService service;


    //  http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) {
        try {
            service.sendSms(request.getTo(), request.getMessage());
            return ResponseEntity.ok("SMS sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send SMS: " + e.getMessage());
        }
    }
}
