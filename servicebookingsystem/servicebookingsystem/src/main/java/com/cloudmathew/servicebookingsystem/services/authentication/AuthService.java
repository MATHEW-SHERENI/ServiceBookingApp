package com.cloudmathew.servicebookingsystem.services.authentication;

import com.cloudmathew.servicebookingsystem.dto.SignupRequestDTO;
import com.cloudmathew.servicebookingsystem.dto.UserDto;

public interface AuthService {
    UserDto SignupClient(SignupRequestDTO signupRequestDTO);


    boolean presentByEmail(String email);

    UserDto SignupCompany(SignupRequestDTO signupRequestDTO);
}
