package com.andre.productapi.converter;

import com.andre.productapi.model.Category;
import com.andre.productapi.model.Product;
import com.andre.shoppingclient.DTO.CategoryDTO;
import com.andre.shoppingclient.DTO.ProductDTO;

public class DTOConverter {

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }

}