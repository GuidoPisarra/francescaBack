package com.francesca.francescabackspring.service;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository repository;

    public ProductService(@Qualifier("productRepository") ProductRepository repository){
        this.repository= repository;
    }

    public Product newProduct (Product p){
        return repository.save(p);
    }

    public List<Product> getProducts(){return repository.findAll();}


    public void deleteProduct(int p) { repository.deleteById(p); }

    public OneProductDTO getProduct(String code) { return repository.getProductByCode(code);}

    public int priceIncreaseWhithPercentajeProduct(float percentaje) { return repository.priceIncreaseWithPercentajeProduct(percentaje); }
}
