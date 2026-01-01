package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dto.AuthResponse;
import com.librarymanagementsystem.dto.UserDTO;
import com.librarymanagementsystem.model.User;
import com.librarymanagementsystem.entity.AuthProvider;
import com.librarymanagementsystem.entity.UserRole;
import com.librarymanagementsystem.mapper.UserMapper;
import com.librarymanagementsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists"); // පස්සේ අපි custom exception දාමු
        }
        // 2. Map DTO to Entity using MapStruct
        User user = userMapper.toUser(userDTO);

        // 3. Set Manual Fields
        user.setPassword(userDTO.getPassword()); // Password Encode කරන්න ඕන
        user.setRole(UserRole.STUDENT); // Default role
        user.setAuthProvider(AuthProvider.LOCAL);
        User savedUser = userRepository.save(user); // 4. Save

        // 5. Return Response (Token එක තාම නෑ, Login එකේදි හදමු)
        return AuthResponse.builder()
                .message("User registered successfully")
                .userId(savedUser.getId())
                .success(true)
                .token(null) // Login වුනාම තමයි Token දෙන්නේ
                .build();
    }
}
