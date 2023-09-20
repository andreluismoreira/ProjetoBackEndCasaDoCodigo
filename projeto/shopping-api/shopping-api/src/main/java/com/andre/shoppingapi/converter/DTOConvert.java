package com.andre.shoppingapi.converter;

import com.andre.shoppingapi.model.Item;
import com.andre.shoppingapi.model.Shop;
import com.andre.shoppingclient.DTO.ItemDTO;
import com.andre.shoppingclient.DTO.ShopDTO;

import java.util.stream.Collectors;

public class DTOConvert {

    public static ItemDTO convert(Item item){
        ItemDTO dto = new ItemDTO();
        dto.setProductIdentifier(item.getProductIdentifier());
        dto.setPrice(item.getPrice());
        return dto;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO dto = new ShopDTO();
        dto.setUserIdentifier(shop.getUserIdentifier());
        dto.setTotal(shop.getTotal());
        dto.setDate(shop.getDate());
        dto.setItensDTO( shop.getItens()
                .stream()
                .map(DTOConvert::convert)
                .collect(Collectors.toList()));
        return dto;
    }

}
