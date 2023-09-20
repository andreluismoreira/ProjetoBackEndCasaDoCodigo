package com.andre.shoppingapi.model;

import com.andre.shoppingclient.DTO.ShopDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String userIdentifier;

    private float total;

    private LocalDateTime date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "id"))
    private List<Item> itens;

    public static Shop convert(ShopDTO dto){
        Shop shop = new Shop();
        shop.setTotal(dto.getTotal());
        shop.setDate(LocalDateTime.now());
        shop.setUserIdentifier(dto.getUserIdentifier());
        shop.setItens(dto.getItensDTO()
                      .stream()
                      .map(Item::convert)
                      .collect(Collectors.toList()));
        return shop;
    }

}
