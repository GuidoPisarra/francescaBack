package com.francesca.francescabackspring.controller;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.service.ProductService;
import com.google.common.net.HttpHeaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductController {

    @Qualifier("productService")
    @Autowired
    private final ProductService service;

    public ProductController(@Qualifier("productService") ProductService service){
        super();
        this.service = service;
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/products")
    public List<Product>  getProducts() {return service.getProducts();}

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/product/{code}")
    public OneProductDTO getProduct(@PathVariable(value="code") String code) {return service.getProduct(code);}

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product p){return service.newProduct(p);}

    @CrossOrigin(origins = "*", methods= {RequestMethod.DELETE})
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="id") int id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/price/{percent}")
    public ResponseEntity<?> priceIncreasePercentProduct(@PathVariable(value="percent") int percent) {
        service.priceIncreasePercentProduct(percent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/products/stock")
    public ResponseEntity<?> addStock(@RequestBody Product p){
        service.addStock(p);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/products/priceOneProduct")
    public ResponseEntity<?> priceOneProduct(@RequestBody Product p){
        service.priceOneProduct(p);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/uploadProducts")
    public List<Product> uploadCSVFile() throws IOException {        
    		return 	service.saveDataFromCSVFile();       
    }
    
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/downloadProducts")
    public void downloadCSVFile(HttpServletResponse response) throws IOException {        
    	service.getDataFromCSVFile(response);
    }        
}
