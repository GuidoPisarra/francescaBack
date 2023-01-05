package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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


    public long deleteProduct(long id) {return repository.deleteProductById(id);}
}
