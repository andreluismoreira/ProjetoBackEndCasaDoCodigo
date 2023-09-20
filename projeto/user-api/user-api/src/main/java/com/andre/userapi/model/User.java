package com.andre.userapi.model;

import com.andre.shoppingclient.DTO.CadastrarUserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cpf;

    private String endereco;

    private String key;

    private String email;

    private String telefone;

    @Column(name = "datacadastro")
    private Timestamp dataCadastro;

    public static User convertCadastro(CadastrarUserDTO dto){
        User user = new User();
        user.setNome(dto.getNome());
        user.setCpf(dto.getCpf());
        user.setEndereco(dto.getEndereco());
        user.setEmail(dto.getEmail());
        user.setTelefone(dto.getTelefone());
        user.setKey(dto.getKey());
        return user;
    }

}
