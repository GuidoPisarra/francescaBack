package com.francesca.francescabackspring.controller;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
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
public class SalesController {

    @Qualifier("salesService")
    @Autowired
    private final SalesService service;

    public SalesController(@Qualifier("salesService") SalesService service){
        super();
        this.service = service;
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/sales")
    public Iterable<Sales> getSales() {return service.getSales();}

    @CrossOrigin(origins = "*", methods= {RequestMethod.DELETE})
    @DeleteMapping("/sales/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable(value="id")int id) {
        service.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/uploadSales")
    public List<Sales> uploadCSVFile() throws IOException {        
    		return 	service.parseCSVFile();       
    }
    
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/downloadSales")
    public void downloadCSVFile(HttpServletResponse response) throws IOException {        
    	service.getDataFromCSVFile(response);
    }


}
