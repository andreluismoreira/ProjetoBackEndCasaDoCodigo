package com.andre.shoppingapi.service;

import com.andre.shoppingclient.DTO.ProductDTO;
import com.andre.shoppingclient.Exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public ProductDTO getProductByIdentifier (String productIdentifier) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8081/product/" + productIdentifier;

            ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);

            return response.getBody();

        }catch (HttpClientErrorException.NotFound e){
            throw new ProductNotFoundException();
        }
    }

}
