package com.lim.redisdb.config;

import com.lim.redisdb.domain.Account;
import com.lim.redisdb.service.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("X-AUTH-TOKEN");

        if (token != null && !token.isBlank()) {
            Account account = authService.validateToken(token); // 기존 @Cacheable 그대로 재사용

            if (account != null) {
                var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + account.getRole()));

                var authentication = new UsernamePasswordAuthenticationToken(
                        account, null, authorities
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}