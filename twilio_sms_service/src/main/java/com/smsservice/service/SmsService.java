package com.smsservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public void sendSms(String to, String message) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(to), // Recipient's phone number
                new PhoneNumber(twilioPhoneNumber), // Your Twilio phone number
                message
        ).create();
    }
}
