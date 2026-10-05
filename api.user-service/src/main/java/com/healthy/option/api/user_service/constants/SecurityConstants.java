package com.healthy.option.api.user_service.constants;

public class SecurityConstants {

    private SecurityConstants() {
    }

    public static final long EXPIRATION_TIME = 432_000_000;// expiration Time
    public static final String TOKEN_HEADER = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String HEALTHY_OPTION_LLC = "Healthy option LLC";
    public static final String HEALTHY_OPTION_ADMINISTRATION = "Healthy Option Portal";
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to login to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String USER_NOT_FOUND_BY_USER_NAME = "User not found by user name ";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS ";
    public static final String[] PUBLIC_URLS = {"/user/login", "/user/register", "/user/reset-password/**", "/user/image/**"};


}
