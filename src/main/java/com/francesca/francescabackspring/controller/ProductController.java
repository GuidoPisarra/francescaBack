package com.francesca.francescabackspring.controller;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@RestController
public class ProductController {

    @Qualifier("productService")
    @Autowired
    private final ProductService service;

    public ProductController(@Qualifier("productService") ProductService service){
        super();
        this.service = service;
    }

    @GetMapping("/products")
    public Iterable<Product> getProduct() {return service.getProducts();}

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product p){return service.newProduct(p);}

    @DeleteMapping("products")
    public long deleteProduct(@RequestBody long id){return service.deleteProduct(id);}

}
