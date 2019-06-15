package com.soprasteria.jwtspringsecuritymongodbangular.securityConfig;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizayionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /*
         */
        String jwt = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(jwt)) {
            throw new RuntimeException("Not Authorized");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
