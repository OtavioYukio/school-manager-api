package com.otavioyukio.school_manager_api.auth;

import com.otavioyukio.school_manager_api.commons.exception.InconsistentDataException;
import com.otavioyukio.school_manager_api.school.School;
import com.otavioyukio.school_manager_api.school.SchoolService;
import com.otavioyukio.school_manager_api.user.Role;
import com.otavioyukio.school_manager_api.user.User;
import com.otavioyukio.school_manager_api.user.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class AuthService {
    private final UserService userService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    AuthService(UserService userService, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        School newSchool = new School(registerRequestDTO.name());
        User newUser = new User(
                registerRequestDTO.email(),
                passwordEncoder.encode(registerRequestDTO.password()),
                newSchool,
                Role.ADMIN
        );
        userService.createUser(newUser);

        String token = tokenService.generateToken(newUser);

        return new RegisterResponseDTO(
                token,
                newUser.getEmail(),
                newUser.getSchool().getName(),
                newUser.getCreatedAt()
        );
    }

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user = userService.findUserByEmail(loginRequestDTO.email());
        if (!passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            throw new InconsistentDataException("Inconsistent data.");
        }

        String token = tokenService.generateToken(user);

        return new LoginResponseDTO(
                token,
                user.getSchool().getName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

    }
}
