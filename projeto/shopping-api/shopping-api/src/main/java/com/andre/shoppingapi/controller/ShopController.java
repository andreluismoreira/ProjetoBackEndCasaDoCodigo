package com.andre.shoppingapi.controller;

import com.andre.shoppingapi.service.ShopService;
import com.andre.shoppingclient.DTO.ShopDTO;
import com.andre.shoppingclient.DTO.ShopReportDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ShopController {

    @Autowired
    ShopService service;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        return service.getAll();
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier){
        return service.getByUser(userIdentifier);
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO dto){
        return service.getByDate(dto);
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO getShops(@PathVariable long id){
        return service.findByid(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(
            @RequestHeader(name = "key") String key,
            @RequestBody ShopDTO dto){
        return service.save(dto, key);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopByFilter(
            @RequestParam(name = "dataInicio", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDateTime dataInicio,
            @RequestParam(name = "dataFim", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDateTime dataFim,
            @RequestParam(name = "valorMinino", required = false) Float valorMinimo){
        return service.getShopsByFilter(dataInicio,dataFim,valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required = true)
            LocalDateTime dataInicio,
            @RequestParam(name = "dataFim", required = false)
            LocalDateTime dataFim){
        return service.getReportDTO(dataInicio,dataFim);
    }

}
