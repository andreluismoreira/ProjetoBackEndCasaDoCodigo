package com.andre.productapi.controller;

import com.andre.productapi.service.ProductService;
import com.andre.shoppingclient.DTO.CadastrarProductDTO;
import com.andre.shoppingclient.DTO.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/product")
    public List<ProductDTO> getProducts(){
        return service.listAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        return service.getProductByCategoryId(categoryId);
    }

    @GetMapping("/product/{productIdentifier}")
    public ProductDTO getProductByIdentifier(@PathVariable String productIdentifier){
        return service.findProductByIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    public ProductDTO createProduct(@Valid @RequestBody CadastrarProductDTO dto){
        return service.save(dto);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }

}
