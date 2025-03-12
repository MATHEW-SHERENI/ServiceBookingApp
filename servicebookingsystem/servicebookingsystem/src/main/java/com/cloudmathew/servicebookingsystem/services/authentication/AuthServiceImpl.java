package com.cloudmathew.servicebookingsystem.services.authentication;

import com.cloudmathew.servicebookingsystem.dto.SignupRequestDTO;
import com.cloudmathew.servicebookingsystem.dto.UserDto;
import com.cloudmathew.servicebookingsystem.entity.User;
import com.cloudmathew.servicebookingsystem.enums.UserRole;
import com.cloudmathew.servicebookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto SignupClient(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    public boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;


    }

    public UserDto SignupCompany(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }

}