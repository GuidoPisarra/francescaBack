package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.OneProductDTO(p.id, p.description, p.costPrice, p.salePrice, p.quantity, p.idProveedor, p.code, p.size ) FROM Product p WHERE p.code = :code")
    OneProductDTO getProductByCode(String code);

    @Query(value = "SELECT p.id FROM Product p WHERE p.salePrice = :percentaje")
    int priceIncreaseWithPercentajeProduct(float percentaje);
}
