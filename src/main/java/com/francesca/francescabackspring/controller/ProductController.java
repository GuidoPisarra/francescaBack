package com.francesca.francescabackspring.controller;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Qualifier("productService")
    @Autowired
    private final ProductService service;

    public ProductController(@Qualifier("productService") ProductService service){
        super();
        this.service = service;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public Iterable<Product> getProducts() {return service.getProducts();}
    @CrossOrigin(origins = "*")
    @GetMapping("/product/{id}")
    public OneProductDTO getProduct(@PathVariable(value="id") int id) {return service.getProduct(id);}
    @CrossOrigin(origins = "*")
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product p){return service.newProduct(p);}

    @CrossOrigin(origins = "*")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="id") int id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
