package com.healthy.option.api.user_service.service.impl;

import com.healthy.option.api.user_service.domain.User;
import com.healthy.option.api.user_service.domain.UserPrincipal;
import com.healthy.option.api.user_service.repo.UserRepository;
import com.healthy.option.api.user_service.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.healthy.option.api.user_service.constants.SecurityConstants.USER_NOT_FOUND_BY_USER_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByUserName(username);
        AtomicReference<UserPrincipal> userPrincipal = new AtomicReference<>();
        optionalUser.ifPresentOrElse(
                user -> {
                    user.setLastLoginDateDisplay(user.getLastLoginDate());
                    user.setLastLoginDate(new Date());
                    userRepo.save(user);
                    userPrincipal.set(new UserPrincipal(user));
                }, () -> {
                    log.error(USER_NOT_FOUND_BY_USER_NAME + "{}", username);
                    throw new UsernameNotFoundException(USER_NOT_FOUND_BY_USER_NAME + username);
                });
        return userPrincipal.get();
    }
}
