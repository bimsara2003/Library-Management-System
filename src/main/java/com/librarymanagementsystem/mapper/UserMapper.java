package com.librarymanagementsystem.mapper;

import com.librarymanagementsystem.dto.UserDTO;
import com.librarymanagementsystem.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Spring Bean එකක් විදිහට වැඩ කරන්න
public interface UserMapper {

    // DTO to Entity (Sign up)
    @Mapping(target = "password", ignore = true) // Password එක කෙලින්ම map කරන්න එපා (Encode කරන්න ඕන නිසා)
    @Mapping(target = "role", ignore = true)     // Role එක logic එකෙන් set කරනවා
    @Mapping(target = "authProvider", ignore = true)
    User toUser(UserDTO userDTO);

    // Entity to DTO (Profile return)
    @Mapping(target = "password", ignore = true) // Password එක එළියට යවන්න එපා
    UserDTO toDTO(User user);
}
