package com.francesca.francescabackspring.service;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        if (repository.getProductByCode(p.getCode())!=null){
            return null;
        }

        return repository.save(p);
    }

    public List<Product> getProducts(){return repository.findAll();}


    public void deleteProduct(int p) { repository.deleteById(p); }

    public OneProductDTO getProduct(String code) { return repository.getProductByCode(code);}

    public void priceIncreasePercentProduct(int percent) {  
        for (Product lis : repository.findAll() ) {
            float newPrice = lis.getSalePrice()+ ( (lis.getSalePrice() * percent)/100 );
            lis.setSalePrice(newPrice);
            repository.save(lis);
        }
    }

    public void addStock(Product p) {
        Product prod = repository.getProductById(p.getId());
        prod.setQuantity(prod.getQuantity()+p.getQuantity());
        repository.save(prod);
    }

    public void priceOneProduct(Product p) {
        Product prod = repository.getProductById(p.getId());
        prod.setSalePrice(p.getSalePrice());
        repository.save(prod);
    }
}
