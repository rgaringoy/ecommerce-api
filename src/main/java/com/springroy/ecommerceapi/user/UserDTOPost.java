package com.springroy.ecommerceapi.user;

public record UserDTOPost(
        Long user_id,
        Integer role_id,
        String username,
        String password,
        String first_name,
        String last_name,
        String email,
        String image,
        String code,
        String ip,
        Integer status
) {
}
