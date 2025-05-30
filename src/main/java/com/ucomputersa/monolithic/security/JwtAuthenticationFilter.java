package com.ucomputersa.monolithic.security;

import com.ucomputersa.monolithic.constant.UserConstant;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;

    JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    //TODO Refresh token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String authHeader = request.getHeader(UserConstant.AUTHORIZATION);
        String requestId = UUID.randomUUID().toString();
        String requestUri = request.getRequestURI();
        MDC.put("requestId", requestId);
        MDC.put("requestUri", requestUri);

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String jwtToken = authHeader.substring(7);
                if (jwtService.isTokenValid(jwtToken)) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                            jwtService.extractUsername(jwtToken), null, jwtService.extractCredentials(jwtToken)
                    );

                    Claims claims = jwtService.extractAllClaims(jwtToken);
                    request.setAttribute(UserConstant.EMAIL, claims.get(UserConstant.EMAIL));
                    request.setAttribute(UserConstant.PHONE_NUMBER, claims.get(UserConstant.PHONE_NUMBER));
                    request.setAttribute(UserConstant.COUNTRY_CODE, claims.get(UserConstant.COUNTRY_CODE));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    MDC.put("userId", authentication.getPrincipal().toString());
                } else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"Forbidden\", \"message\": \"Invalid token\"}");
                    return;
                }
            }

            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("requestId");
            MDC.remove("userId");
            MDC.remove("requestUri");

        }
    }

}
