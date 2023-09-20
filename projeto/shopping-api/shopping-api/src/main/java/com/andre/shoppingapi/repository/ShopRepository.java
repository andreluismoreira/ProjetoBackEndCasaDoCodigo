package com.andre.shoppingapi.repository;

import com.andre.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> , ReportRepository{

    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(float total);

    List<Shop> findAllByDateGreaterThan(LocalDateTime sellDate);

}
