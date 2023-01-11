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

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.OneProductDTO(p.id, p.description,p.price, p.size, p.quantity) FROM Product p WHERE p.id = :id")
    OneProductDTO getProductById(int id);
}
