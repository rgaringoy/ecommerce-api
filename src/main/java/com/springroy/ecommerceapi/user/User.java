package com.springroy.ecommerceapi.user;


import com.springroy.ecommerceapi.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ec_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ec_user_seq", allocationSize = 1)
    private Long userId;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 20, message = "Username must be at least 3 characters long")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 3, max = 20, message = "Password must be at least 3 characters long")
    private String password;

    @NotBlank(message = "First Name must not be blank")
    @Size(min = 3, max = 20, message = "First Name must be at least 3 characters long")
    private String firstName;

    @NotBlank(message = "Last Name must not be blank")
    @Size(min = 3, max = 20, message = "Last Name must be at least 3 characters long")
    private String lastName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    private String image;

    @NotBlank(message = "Code must not be blank")
    @Size(min = 1, max = 5,message = "Code must be at least 1 characters long")
    private String code;

    @NotBlank(message = "IP Address must not be blank")
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ip;

    @NotBlank(message = "Status must not be blank")
    @Size(max = 1, message = "Please provide a status")
    private Integer status;


    private Integer roleId;

}
