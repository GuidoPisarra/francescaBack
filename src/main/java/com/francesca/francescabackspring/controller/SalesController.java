package com.francesca.francescabackspring.controller;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {

    @Qualifier("salesService")
    @Autowired
    private final SalesService service;

    public SalesController(@Qualifier("salesService") SalesService service){
        super();
        this.service = service;
    }

    @GetMapping("/sales")
    public Iterable<Sales> getSales() {return service.getSales();}

    @PostMapping("/sales")
    public Sales newSale(@RequestBody Sales s){return service.newSales(s);}

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable(value="id")int id) {
        service.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sales/salesReport")
    public List<ReportSalesDay> getReportSalesDay(){ return service.getReportSalesDay(); }

}
