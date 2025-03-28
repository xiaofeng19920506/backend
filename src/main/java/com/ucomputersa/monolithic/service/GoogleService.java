package com.ucomputersa.monolithic.service;

import org.springframework.stereotype.Service;

@Service
public class GoogleService {

//    @Value("${spring.security.oauth2.client.registration.google.client-id}")
//    private String clientId;
//
//    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
//    private String clientSecret;
//
//    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
//    private String redirectUri;
//
//    private final List<String> SCOPES = List.of(GmailScopes.GMAIL_LABELS);
//
//
//    public GoogleIdTokenVerifier getGoogleIdTokenVerifier() {
//        return new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
//                .setAudience(java.util.Collections.singletonList(clientId))
//                .build();
//    }
//
//    public GoogleAuthorizationCodeTokenRequest getGoogleAuthorizationCodeTokenRequest(String code) {
//        GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow = new GoogleAuthorizationCodeFlow.Builder(new NetHttpTransport(),
//                GsonFactory.getDefaultInstance(), clientId, clientSecret, SCOPES).build();
//        return googleAuthorizationCodeFlow.newTokenRequest(code).setRedirectUri(redirectUri);
//    }

}


