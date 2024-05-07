package com.crud.pokemon.service.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crud.pokemon.exceptions.NullUserException;
import com.crud.pokemon.model.User;
import com.crud.pokemon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Value("${api.security.token.secret}")
    private String secretKey;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(User data) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String token = JWT.create()
                    .withIssuer("pokemon-crud")
                    .withSubject(data.getUsername())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException ex) {
            throw new RuntimeException();
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer("pokemon-crud")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            return "";
        }
    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public Optional<User> getAuthUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return userRepository.loadByUsername(username);
        } else
            throw new NullUserException();
    }
}
