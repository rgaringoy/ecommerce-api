package com.springroy.ecommerceapi.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOViewMapper implements Function<User, UserDTOView> {

    @Override
    public UserDTOView apply(User user) {
        return new UserDTOView(
                user.getUserId(),
                user.getRoleId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getImage(),
                user.getCode(),
                user.getIp(),
                user.getStatus(),
                user.getCreatedAt(),
                user.getCreatedBy()
        );
    }
}
