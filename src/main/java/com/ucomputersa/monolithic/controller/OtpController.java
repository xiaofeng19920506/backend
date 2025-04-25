package com.ucomputersa.monolithic.controller;

import com.ucomputersa.monolithic.service.otpServices.TwilioVerifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OtpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OtpController.class);

    @Autowired
    private TwilioVerifyService twilioVerifyService;

    /**
     * Send an OTP to the given phone number.
     *
     * @param phoneNumber The phone number to send the OTP to.
     * @return A success message.
     */
//    @PostMapping("/send")
//    public ResponseEntity<R> sendOtp(@RequestBody SendOtpRequestDTO sendOtpRequestDTO) {
//        try {
//            twilioVerifyService.sendOtp(sendOtpRequestDTO.getPhoneNumber());
//        } catch (ApiException e) {
//            LOGGER.error("Twilio API Error: {}", e.getMessage());
//            throw new RuntimeException("Failed to send OTP: " + e.getMessage());
//        }
//
//        return ResponseEntity.ok(R.ok("OTP sent successfully!"));
//    }

}