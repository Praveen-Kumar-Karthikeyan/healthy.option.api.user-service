package com.healthy.option.api.user_service.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthy.option.api.user_service.domain.HttpResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

import static com.healthy.option.api.user_service.constants.SecurityConstants.USER_NOT_FOUND_BY_USER_NAME;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpResponse httpResponse = new HttpResponse(UNAUTHORIZED.value(),
                UNAUTHORIZED, UNAUTHORIZED.getReasonPhrase().toUpperCase(),
                USER_NOT_FOUND_BY_USER_NAME);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(UNAUTHORIZED.value());
        OutputStream outputStream = response.getOutputStream();
        objectMapper.writeValue(outputStream, httpResponse);
        outputStream.flush();
    }
}
