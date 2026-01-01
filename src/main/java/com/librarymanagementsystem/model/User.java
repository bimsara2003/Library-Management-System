package com.librarymanagementsystem.model;

import com.librarymanagementsystem.entity.UserRole;
import com.librarymanagementsystem.entity.AuthProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password; // Can be null for OAuth users

    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role; // ADMIN, STUDENT, LIBRARIAN

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.LOCAL; // LOCAL, GOOGLE

    private String googleId;

    private String profileImage;

    private boolean verified = false;

    private LocalDateTime lastLogin;
}
