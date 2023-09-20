package com.andre.productapi.model;

import com.andre.shoppingclient.DTO.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public static Category convert(CategoryDTO dto){
        Category category = new Category();
        category.setId(dto.getId());
        category.setNome(dto.getNome());
        return category;
    }

}
