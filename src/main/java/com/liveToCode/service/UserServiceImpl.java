package com.liveToCode.service;

import com.liveToCode.dto.UserDTO;
import com.liveToCode.entity.User;
import com.liveToCode.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        User dbUser = userRepository.save(user);

        userDTO.setId(dbUser.getId());

        return userDTO;
    }
}
