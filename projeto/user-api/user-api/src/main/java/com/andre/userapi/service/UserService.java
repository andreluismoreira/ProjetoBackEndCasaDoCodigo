package com.andre.userapi.service;

import com.andre.shoppingclient.DTO.CadastrarUserDTO;
import com.andre.shoppingclient.DTO.UserDTO;

import com.andre.shoppingclient.Exception.UserNotFoundException;
import com.andre.userapi.converter.DTOConverter;
import com.andre.userapi.model.User;
import com.andre.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAll(){
        List<User> user = userRepository.findAll();
        return user
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.map(DTOConverter::convert).orElse(null);
    }

    public UserDTO save(CadastrarUserDTO dto){
        User user = User.convertCadastro(dto);
        user.setDataCadastro(Timestamp.from(Instant.now()));
        //Gerador de UUID
        user.setKey(UUID.randomUUID().toString());

        userRepository.save(user);
        return DTOConverter.convert(user);
    }

    public UserDTO delete(long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return DTOConverter.convert(user.get());
        }
        throw new UserNotFoundException();
    }

    public UserDTO findByCPFAndKey(String cpf, String key){
        User user = userRepository.findByCpfAndKey(cpf, key);
        if(user != null){
            return DTOConverter.convert(user);
        }
        throw new UserNotFoundException();
    }

    public List<UserDTO> queryByName(String name){
        List<User> user = userRepository.findByNomeStartingWith(name);
        if (user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

}
