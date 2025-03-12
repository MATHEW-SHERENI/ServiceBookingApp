package com.cloudmathew.servicebookingsystem.dto;

import com.cloudmathew.servicebookingsystem.enums.UserRole;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {
    @Id
    private Long Id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;

    public void setRole(UserRole role) {
    }

    public void setId(Long id) {
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }
}
