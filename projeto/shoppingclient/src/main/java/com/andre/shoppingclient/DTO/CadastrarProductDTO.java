package com.andre.shoppingclient.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarProductDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String productIdentifier;

    @NotNull
    private Float preco;

    @NotNull
    private CategoryDTO categoryDTO;

}
