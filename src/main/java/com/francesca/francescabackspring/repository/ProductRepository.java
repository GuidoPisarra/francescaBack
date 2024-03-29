package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.OneProductDTO(p.id, p.description, p.costPrice, p.salePrice, p.quantity, p.idProveedor, p.code, p.size ) FROM Product p WHERE p.code = :code AND p.activo = 0")
    OneProductDTO getProductByCode(String code);
    @Query(value = "SELECT p FROM Product p WHERE p.id= :id")
    Product getProductById(int id);
    
    @Query(value = "SELECT p FROM Product p WHERE p.activo=0")
	List<Product> findAllActive();
    
    @Query(value = "SELECT p FROM Product p WHERE p.code = :code AND p.activo = 0")
	List<Product> getReferenceByCodeAll(String code);
    
    @Query(value = "SELECT p FROM Product p WHERE p.id = :idProduct AND p.activo = 0")
	Product getProductByIdActive(int idProduct);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.salePrice =CEIL( p.salePrice +((p.salePrice  * :percent )/100)) WHERE p.activo = 0")
	void updatePrice(float percent);
    

}
