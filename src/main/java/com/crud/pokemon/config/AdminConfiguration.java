package com.crud.pokemon.config;

import com.crud.pokemon.model.User;
import com.crud.pokemon.model.enums.Role;
import com.crud.pokemon.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class AdminConfiguration implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    Logger logger = Logger.getLogger(AdminConfiguration.class.getName());


    public AdminConfiguration(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        DotEnv dotEnv = new DotEnv();
        var user = new User("Administrator",
                dotEnv.getAdminUsername(),
                encoder.encode(dotEnv.getAdminPassword()),
                Role.ADMIN);
        Optional<User> optionalUser = userRepository.loadByUsername(user.getUsername());
        optionalUser.ifPresentOrElse(
                userValue -> logger.log(Level.INFO, String.format(
                        "-> Admin logged in: User(Name: %s, Username: %s, Role: %s)%n",
                        userValue.getName(), userValue.getUsername(), userValue.getRole())),
                () -> userRepository.save(user));
    }
}
