package com.ucomputersa.monolithic.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TokenBlackListService {
    private final Set<String> blacklistTokens = new HashSet<>();

    public void blacklistToken(String token) {
        blacklistTokens.add(token);
    }

    public boolean isTokenBlacklisted(String token){
        return blacklistTokens.contains(token);
    }
}
