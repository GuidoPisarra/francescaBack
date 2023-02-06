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

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.SalesDTO(s.id, s.idProduct) FROM Sales s")
    List<SalesDTO> getAllSales();

    @Query("SELECT COALESCE(SUM(sp.price*sp.quantity), 0)" +
            "FROM SalesProduct sp " +
            "JOIN Sales s " +
            "ON s.id = sp.idSale "+
            "JOIN  Product p " +
            "ON p.id = s.idProduct "+
            "WHERE MONTH(sp.SaleProductDate)= :month AND YEAR(sp.SaleProductDate)= :year "

    )
    float getIncomes(int month, int year);
}
