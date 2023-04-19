package com.springroy.ecommerceapi.user;

import java.time.LocalDateTime;

public record UserDTOView(
        Long user_id,
        Integer role_id,
        String username,
        String first_name,
        String last_name,
        String email,
        String image,
        String code,
        String ip,
        Integer status,
        LocalDateTime created_at,
        Integer created_by
) {
}
