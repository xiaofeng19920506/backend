package com.ucomputersa.monolithic.utils;

import com.ucomputersa.monolithic.constant.RoleEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

public class AuthenticationUtil {


    public static String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            throw new IllegalStateException("User is not authenticated");
        }
        if (authentication.getPrincipal() instanceof String userId) {
            if (StringUtils.hasText(userId)) {
                return userId;
            }
        }
        throw new IllegalStateException("Invalid User");
    }

    public static boolean hasRole(RoleEnum role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getAuthorities() == null) {
            return false;
        }

        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(authority -> {
                    try {
                        return RoleEnum.valueOf(authority).equals(role);
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                });
    }
}
