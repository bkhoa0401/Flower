package com.ecommerce.wProductService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.wProductService.service.imp.UserServiceImp;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticateRequest extends OncePerRequestFilter {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserServiceImp userServiceImp;

    @Value("${isDebug}")
    private boolean isDebug;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Authorization");
        if (token != null && tokenProvider.validateToken(token)) {
            String usernameFromToken = tokenProvider.getUserNameByToken(token);
            UserDetails user = userServiceImp.loadUserByUsername(usernameFromToken);

            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            if (user != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
