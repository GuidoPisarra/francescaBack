package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.SalesDTO(s.id, s.idProduct,s.quantity,s.price) FROM Sales s")
    List<SalesDTO> getAllSales();

}
