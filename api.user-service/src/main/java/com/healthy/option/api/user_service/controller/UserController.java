package com.healthy.option.api.user_service.controller;

import com.healthy.option.api.user_service.exception.EmailExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String publicApi() {
        return "Hello-World From Public API";
    }

    @GetMapping("/home")
    public String securedApi() throws EmailExistException {
        throw new EmailExistException("This email address is already taken");
    }


}
