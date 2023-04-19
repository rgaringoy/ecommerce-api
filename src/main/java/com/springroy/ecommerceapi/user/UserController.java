package com.springroy.ecommerceapi.user;

import com.springroy.ecommerceapi.model.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTOView>> getAllUser() {
        List<UserDTOView> users = userService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @PostMapping
    public ResponseEntity<Response> addNewUser(
            @Valid @RequestBody UserDTOPost userDTOPost
    ) {
        boolean usedUsernameAndEmail = userService.createNewUser(userDTOPost);
        Response response = new Response();

        if (!usedUsernameAndEmail) {
            response.setStatusCode("201");
            response.setStatusMessage("User has been successfully created!");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("isUserSaved", "true")
                    .body(response);
        } else {
            response.setStatusCode("400");
            response.setStatusMessage("Username or Email has been already registered!");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("isUserSaved", "false")
                    .body(response);
        }
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Response> deleteUser(
            @PathVariable Integer user_id
    ) {
        userService.removeUser(user_id);
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMessage("User has been deleted!");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("isDeleted","true")
                .body(response);
    }

    @PutMapping
    public ResponseEntity<Response> editUser(
            @Valid @RequestBody UserDTOPost userDTOPost
    ) {
            boolean isUpdated = userService.updateUser(userDTOPost);
            Response Response = new Response();

            if (isUpdated) {
                Response.setStatusCode("201");
                Response.setStatusMessage("User has been successfully updated!");
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .header("isUserUpdated", "true")
                        .body(Response);
            } else {
                Response.setStatusCode("400");
                Response.setStatusMessage("User could not be updated");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("isUserUpdated", "false")
                        .body(Response);
            }
    }
}
