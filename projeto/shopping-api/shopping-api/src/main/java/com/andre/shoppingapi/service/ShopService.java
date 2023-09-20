package com.andre.shoppingapi.service;

import com.andre.shoppingapi.model.Shop;
import com.andre.shoppingapi.repository.ShopRepository;
import com.andre.shoppingapi.converter.DTOConvert;
import com.andre.shoppingclient.DTO.*;
import com.andre.shoppingclient.Exception.ProductNotFoundException;
import com.andre.shoppingclient.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    ShopRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    public List<ShopDTO> getAll(){
        List<Shop> shop = repository.findAll();
        return shop
                .stream()
                .map(DTOConvert::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier){
        List<Shop> shop = repository.findAllByUserIdentifier(userIdentifier);
        return shop
                .stream()
                .map(DTOConvert::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO dto){
        List<Shop> shop = repository.findAllByDateGreaterThan(dto.getDate());
        return shop
                .stream()
                .map(DTOConvert::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findByid(long ProductId){
        Optional<Shop> shop = repository.findById(ProductId);
        if (shop.isPresent()){
            return DTOConvert.convert(shop.get());
        }
       throw new ProductNotFoundException();
    }

    public ShopDTO save(ShopDTO dto, String key){
        UserDTO userDTO = userService.getUserByCpf(dto.getUserIdentifier(), key);

        if (userDTO == null){
            throw new UserNotFoundException();
        }
        if (!validateProducts(dto.getItensDTO())){
            throw new ProductNotFoundException();
        }

        dto.setTotal(dto.getItensDTO()
                .stream()
                .map(ItemDTO::getPrice)
                .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(dto);
        shop.setDate(LocalDateTime.now());
        Shop shopping = repository.save(shop);

        return DTOConvert.convert(shopping);
    }

    public List<ShopDTO> getShopsByFilter(LocalDateTime dataInicio, LocalDateTime dataFim, Float valorMinimo){
        List<Shop> shops = repository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(DTOConvert::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportDTO(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return repository.getReportByDate(dataInicio, dataFim);
    }

    private boolean validateProducts(List<ItemDTO> itensDTO) {
        for (ItemDTO item : itensDTO) {
            ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
            if (productDTO == null){
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }

}
