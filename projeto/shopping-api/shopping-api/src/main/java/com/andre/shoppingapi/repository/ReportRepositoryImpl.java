package com.andre.shoppingapi.repository;

import com.andre.shoppingapi.model.Shop;
import com.andre.shoppingclient.DTO.ShopReportDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


import java.time.LocalDateTime;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(LocalDateTime dataInicio, LocalDateTime dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :dataInicio ");

        if (dataFim != null){
            sb.append("and s.date <= :dataFim ");
        }

        if (valorMinimo != null){
            sb.append("and s.total <= :valorMinimo ");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);

        if (dataFim != null){
            query.setParameter("dataFim", dataFim);
        }

        if (valorMinimo != null){
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(LocalDateTime dataInicio, LocalDateTime dataFim) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        stringBuilder.append("from shop sp ");
        stringBuilder.append("where sp.date >= :dataInicio ");
        stringBuilder.append("and sp.date <= :dataFim ");

        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO dto = new ShopReportDTO();
        dto.setCount((Long) result[0]); //erro de tipo
        dto.setTotal((Double) result[1]);
        dto.setMean((Double) result[2]);

        return dto;
    }
}
