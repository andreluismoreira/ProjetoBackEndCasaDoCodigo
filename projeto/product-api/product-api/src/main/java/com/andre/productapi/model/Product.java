package com.andre.productapi.model;

import com.andre.shoppingclient.DTO.CadastrarProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String descricao;

    @Column(name = "productidentifier")
    private String productIdentifier;

    private Float preco;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convertCadastrarPrdDTO(CadastrarProductDTO dto){
        Product product = new Product();
        product.setNome(dto.getNome());
        product.setDescricao(dto.getDescricao());
        product.setPreco(dto.getPreco());
        product.setProductIdentifier(dto.getProductIdentifier());
        if(dto.getCategoryDTO() != null){
            product.setCategory(Category.convert(dto.getCategoryDTO()));
        }
        return product;
    }

}
