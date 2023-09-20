package com.andre.productapi.service;

import com.andre.productapi.model.Product;
import com.andre.productapi.repository.ProductRepository;
import com.andre.productapi.converter.*;
import com.andre.shoppingclient.DTO.CadastrarProductDTO;
import com.andre.shoppingclient.DTO.ProductDTO;
import com.andre.shoppingclient.Exception.CategoryNotFoundException;
import com.andre.shoppingclient.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDTO> listAll(){
        List<Product> produtos = repository.findAll();
        return produtos
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO>  getProductByCategoryId(Long categoryId){
        List<Product>  produtos = repository.getProductByCategory(categoryId);
        return produtos
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findProductByIdentifier(String identifier){
        Product prd = repository.findByProductIdentifier(identifier);
        if(prd != null){
            return DTOConverter.convert(prd);
        }
        throw new ProductNotFoundException();
    }

    public ProductDTO save(CadastrarProductDTO dto){
        boolean existsCategory = repository.existsById(dto.getCategoryDTO().getId());
        if (!existsCategory){
            throw new CategoryNotFoundException();
        }
        Product prd = Product.convertCadastrarPrdDTO(dto);
        repository.save(prd);
        return DTOConverter.convert(prd);
    }

    public void delete(long id) {
        Optional<Product> prd = repository.findById(id);
        prd.ifPresent(product -> repository.delete(product));
        throw new ProductNotFoundException();
    }

}
