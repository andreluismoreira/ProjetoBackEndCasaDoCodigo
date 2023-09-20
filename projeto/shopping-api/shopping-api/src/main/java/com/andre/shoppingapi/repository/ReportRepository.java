package com.andre.shoppingapi.repository;

import com.andre.shoppingapi.model.Shop;
import com.andre.shoppingclient.DTO.ShopReportDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(LocalDateTime dataInicio, LocalDateTime dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(LocalDateTime dataInicio, LocalDateTime dataFim);

}
