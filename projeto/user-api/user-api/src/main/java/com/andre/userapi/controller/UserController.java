package com.andre.userapi.controller;


import com.andre.shoppingclient.DTO.CadastrarUserDTO;
import com.andre.shoppingclient.DTO.UserDTO;
import com.andre.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot is working";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public UserDTO getById(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping("/users/cpf/{cpf}")
    public UserDTO findByCpfAndKey(@RequestParam(name = "key") String key,
                                   @PathVariable String cpf){
        return userService.findByCPFAndKey(cpf, key);
    }

    @PostMapping("/newUser")
    public UserDTO inserir(@RequestBody CadastrarUserDTO userDTO){
        return userService.save(userDTO);
    }

    @DeleteMapping("/remover/{id}")
    public UserDTO remover(@PathVariable long id) {
        return userService.delete(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome") String nome){
        return userService.queryByName(nome);
    }

}
