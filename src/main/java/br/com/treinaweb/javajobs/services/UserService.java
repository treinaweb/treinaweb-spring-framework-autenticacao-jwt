package br.com.treinaweb.javajobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.javajobs.dto.UserDTO;
import br.com.treinaweb.javajobs.mappers.UserMapper;
import br.com.treinaweb.javajobs.models.User;
import br.com.treinaweb.javajobs.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User create(UserDTO userDTO) {
        User userToCreate = userMapper.toModel(userDTO);

        return userRepository.save(userToCreate);
    }

}
