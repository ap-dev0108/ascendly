package com.example.worklens.seed;

import com.example.worklens.entity.User;
import com.example.worklens.repository.CreatorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreatorSeed implements CommandLineRunner {
    private final CreatorRepository _creator;
    private final PasswordEncoder _password;

    public CreatorSeed(CreatorRepository creator, PasswordEncoder password) {
        this._creator = creator;
        this._password = password;
    }

    @Override
    public void run(String...args) {
        if(!_creator.existsByEmail("aryan@worklens.com")) {
            User creator = new User();

            creator.setEmail("aryan@worklens.com");
            creator.setFull_name("Aryan");
            creator.setPassword(_password.encode("aryan@worklens"));

            _creator.save(creator);

            System.out.println("Creator account seeded");
        }
    }
}
