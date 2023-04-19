package com.springroy.ecommerceapi.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOPostMapper implements Function<User, UserDTOPost> {

    @Override
    public UserDTOPost apply(User user) {
        return new UserDTOPost(
                user.getUserId(),
                user.getRoleId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getImage(),
                user.getCode(),
                user.getIp(),
                user.getStatus()
        );
    }
}
