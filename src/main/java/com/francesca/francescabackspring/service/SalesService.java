package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.SalesProductRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
import com.google.common.net.HttpHeaders;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Service
public class SalesService {

    @Qualifier("salesRepository")
    @Autowired
    private SalesRepository repository;
    @Qualifier("salesProductRepository")
    @Autowired
    private SalesProductRepository salesProductrepository;
    public SalesService(@Qualifier("salesRepository") SalesRepository repository){
        this.repository= repository;
    }

    public List<Sales> getSales(){return repository.findAll();}


    public void deleteSale(int p) { repository.deleteById(p); }

    @SuppressWarnings("null")
	public List<Sales> parseCSVFile() throws IOException {
		List<String[]> data = new ArrayList<>();
		InputStream inputStream = new FileInputStream("src/csv/Sales.csv");



	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	      
			CSVParser parser = null;

			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/Products.csv"));
	        
	        for(CSVRecord row: parser) {
				
				Sales s = new Sales (
		        Integer.parseInt(row.get("idProduct"))
		        );
				
				System.out.println(s.toString());
	
				repository.save(s);		        
	        }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	        

	    return repository.findAll();
	}

	public void getDataFromCSVFile(HttpServletResponse response) throws IOException {
		List<Sales> sales = repository.findAll(); // Obtenemos todos los productos desde la base de datos
        String filename = "sales.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

        try (PrintWriter writer = response.getWriter()) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("id", "idProduct"));
            for (Sales sale : sales) {
                csvPrinter.printRecord(
                        sale.getId(),
                        sale.getIdProduct()                       
                );
            }
            csvPrinter.flush();
        }
	}

}
