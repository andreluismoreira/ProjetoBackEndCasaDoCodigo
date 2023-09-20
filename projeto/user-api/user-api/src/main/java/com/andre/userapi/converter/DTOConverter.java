package com.andre.userapi.converter;

import com.andre.shoppingclient.DTO.UserDTO;
import com.andre.userapi.model.User;

public class DTOConverter {

    public static UserDTO convert(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEndereco(user.getEndereco());
        dto.setCpf(user.getCpf());
        dto.setEmail(user.getEmail());
        dto.setTelefone(user.getTelefone());
        dto.setDataCadastro(user.getDataCadastro());
        dto.setKey(user.getKey());
        return dto;
    }
}
