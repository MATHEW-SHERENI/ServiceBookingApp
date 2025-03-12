package com.cloudmathew.servicebookingsystem.controller;

import com.cloudmathew.servicebookingsystem.dto.SignupRequestDTO;
import com.cloudmathew.servicebookingsystem.dto.UserDto;
import com.cloudmathew.servicebookingsystem.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;
@PostMapping("/client/sign-up")
    public ResponseEntity<?> SignupClient(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("CLIENT ALREADY EXIST", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser= authService.SignupClient(signupRequestDTO);

            return new ResponseEntity<>(createdUser,HttpStatus.OK);
        }
    @PostMapping("/company/sign-up")
    public ResponseEntity<?> SignupCompany(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Company ALREADY EXIST", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser= authService.SignupClient(signupRequestDTO);

        return new ResponseEntity<>(createdUser,HttpStatus.OK);
    }

    }

