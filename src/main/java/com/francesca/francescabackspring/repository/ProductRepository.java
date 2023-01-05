package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "DELETE FROM Product p WHERE p.id = :id")
    long deleteProductById(long id);

}
