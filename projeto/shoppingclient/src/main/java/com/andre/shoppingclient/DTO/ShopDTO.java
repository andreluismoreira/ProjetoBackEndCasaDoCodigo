package com.andre.shoppingclient.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

    @NotBlank
    private String userIdentifier;

    private Float total;

    private LocalDateTime date;

    @NotNull
    private List<ItemDTO> itensDTO;

}
