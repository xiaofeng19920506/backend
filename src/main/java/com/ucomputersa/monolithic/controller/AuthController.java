package com.ucomputersa.monolithic.controller;


import com.twilio.exception.ApiException;
import com.ucomputersa.monolithic.domain.R;
import com.ucomputersa.monolithic.domain.model.User;
import com.ucomputersa.monolithic.domain.dto.LoginRequestDTO;
import com.ucomputersa.monolithic.domain.dto.RegisterRequestDTO;
import com.ucomputersa.monolithic.domain.model.JwtModel;
import com.ucomputersa.monolithic.service.AuthService;
import com.ucomputersa.monolithic.service.GoogleService;
import com.ucomputersa.monolithic.service.otpServices.TwilioVerifyService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

//    private final GoogleIdTokenVerifier verifier;

    private final AuthService authService;

    private final TwilioVerifyService twilioVerifyService;


    @PostMapping("/register")
    public ResponseEntity<R> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {

        try {
            User user = User.builder().build();
            BeanUtils.copyProperties(registerRequestDTO, user);
            authService.registerUser(user);
            return ResponseEntity.ok(R.ok());
        } catch (
                ApiException e) {
            LOGGER.error("Twilio API Error: {}", e.getMessage());
            throw new RuntimeException("Failed to verify OTP: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<R> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = User.builder().email(loginRequestDTO.getEmail()).password(loginRequestDTO.getPassword()).build();

        JwtModel jwtModel = authService.loginWithPassword(user);

        return ResponseEntity.ok(R.ok().with("data", jwtModel));
    }


//    @PostMapping("/oauth2.0/login")
//    public ResponseEntity<JwtModel> oauthGoogleLogin(@RequestBody() Map<String, String> idToken) {
//        try {
//            GoogleIdToken.Payload payload = verifier.verify(idToken.get("idToken")).getPayload();
//            JwtModel jwtModel = authService.oauthGoogleLogin(payload);
//            return ResponseEntity.ok(jwtModel);
//
//        } catch (GeneralSecurityException | IOException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

}