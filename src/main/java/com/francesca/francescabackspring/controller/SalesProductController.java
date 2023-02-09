package com.francesca.francescabackspring.controller;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.service.SalesProductService;
import com.francesca.francescabackspring.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SalesProductController {

    @Qualifier("salesProductService")
    @Autowired
    private final SalesProductService service;

    public SalesProductController(@Qualifier("salesProductService") SalesProductService service){
        this.service = service;
    }
    @GetMapping("/salesProduct")
    public List<SalesProduct> getSalesProduct(){ return service.getSalesProduct(); }

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/salesProduct/salesReport")
    public List<ReportSalesDay> getReportSalesDay(){ return service.getReportSalesDay(); }

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/salesProduct")
    public List<SalesProduct> newSalesProduct(@RequestBody List<SalesProduct> sp){ return service.newSalesProduct(sp); }

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/uploadSalesProduct")
    public List<SalesProduct> uploadCSVFile() throws IOException {        
    		return 	service.saveDataFromCSVFile();       
    }
    
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/downloadSalesProduct")
    public void downloadCSVFile(HttpServletResponse response) throws IOException {        
    	service.getDataFromCSVFile(response);
    }
}
