package com.example.worklens.services;

import com.example.worklens.dto.RegisterDTO;
import com.example.worklens.entity.User;
import com.example.worklens.repository.UserRepository;
import com.example.worklens.services.interfaces.AuthImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthServices implements AuthImpl {
    private final UserRepository userRepository;

    public AuthServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String RegisterUser(RegisterDTO registerDTO) {
        var user = new User();

        user.full_name = registerDTO.full_name;
        user.email = registerDTO.email;
        user.password = registerDTO.password;

        userRepository.save(user);
        return "Registration Done I guess";
    }
}
