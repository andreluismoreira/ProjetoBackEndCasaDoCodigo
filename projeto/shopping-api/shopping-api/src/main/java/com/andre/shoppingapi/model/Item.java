package com.andre.shoppingapi.model;

import com.andre.shoppingclient.DTO.ItemDTO;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Item {

    private String productIdentifier;

    private float price;

    public static Item convert(ItemDTO dto){
        Item item = new Item();
        item.setProductIdentifier(dto.getProductIdentifier());
        item.setPrice(dto.getPrice());
        return item;
    }

}
