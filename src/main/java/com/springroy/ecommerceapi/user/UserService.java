package com.springroy.ecommerceapi.user;

import java.util.List;

public interface UserService {

    List<UserDTOView> getAll();

    boolean createNewUser(UserDTOPost userDTOPost);

    void removeUser(Integer userId);

    boolean updateUser(UserDTOPost userDTOPost);
}
