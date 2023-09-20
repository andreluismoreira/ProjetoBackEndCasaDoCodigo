package com.andre.shoppingclient.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CadastrarUserDTO {

    private String nome;

    private String cpf;

    private String endereco;

    private String email;

    private String telefone;

    private String key;

}
