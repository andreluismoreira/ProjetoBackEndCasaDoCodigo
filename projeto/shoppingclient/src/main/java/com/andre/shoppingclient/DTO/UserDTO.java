package com.andre.shoppingclient.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String nome;

    private String cpf;

    private String endereco;

    private String key;

    private String email;

    private String telefone;

    private Timestamp dataCadastro;

}
