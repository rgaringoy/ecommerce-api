package com.springroy.ecommerceapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOViewMapper userDTOViewMapper;

    @Override
    public List<UserDTOView> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userDTOViewMapper)
                .toList();
    }

    @Override
    public boolean createNewUser(UserDTOPost userDTOPost) {
        boolean isSaved = false;
        Optional<User> usernameAndEmail = userRepository.getByUsernameAndEmail(
                userDTOPost.username(), userDTOPost.email()
        );
        if (usernameAndEmail.isPresent()) {
            isSaved = true;
        } else {
            User user = new User();
            user.setRoleId(userDTOPost.role_id());
            user.setUsername(userDTOPost.username());
            user.setPassword(userDTOPost.password());
            user.setFirstName(userDTOPost.first_name());
            user.setLastName(userDTOPost.last_name());
            user.setEmail(userDTOPost.email());
            user.setImage(userDTOPost.image());
            user.setCode(userDTOPost.code());
            user.setIp(userDTOPost.ip());
            user.setStatus(userDTOPost.status());
            userRepository.save(user);
        }
        return isSaved;
    }

    @Override
    public void removeUser(Integer userId) {
        userRepository.deleteById(Long.valueOf(userId));
    }

    @Override
    public boolean updateUser(UserDTOPost userDTOPost) {
        boolean isUpdated = false;
        Optional<User> userToUpdate = userRepository.findById(userDTOPost.user_id());

        if (userToUpdate.isPresent()) {
            userToUpdate.get().setRoleId(userDTOPost.role_id());
            userToUpdate.get().setUsername(userDTOPost.username());
            userToUpdate.get().setPassword(userDTOPost.password());
            userToUpdate.get().setFirstName(userDTOPost.first_name());
            userToUpdate.get().setLastName(userDTOPost.last_name());
            userToUpdate.get().setEmail(userDTOPost.email());
            userToUpdate.get().setImage(userDTOPost.image());
            userToUpdate.get().setCode(userDTOPost.code());
            userToUpdate.get().setIp(userDTOPost.ip());
            userToUpdate.get().setStatus(userDTOPost.status());
            User row = userRepository.save(userToUpdate.get());

            if (row.getUserId() > 1) {
                isUpdated = true;
            }
        }
        return isUpdated;

    }


}
