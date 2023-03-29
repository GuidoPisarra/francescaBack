package com.francesca.francescabackspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.francesca.francescabackspring.DTO.ProductDTO;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.ProductRepository;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Service
public class SalesProductService {
    @Qualifier("salesProductRepository")
    @Autowired
    private SalesProductRepository repository;
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductRepository productRepository;


    public SalesProduct newRegister(SalesProduct sp){return repository.save(sp);};

    public List<SalesProduct> getSalesProduct() {
        return repository.findAll();
    }

    public List<ReportSalesDay> getReportSalesDay() {
      return repository.getSalesReport();
    }


    public List<SalesProduct> newSalesProduct(List<SalesProduct> sp) {
        int saleId = 0;
        for (SalesProduct lis : sp){
            Product saleProduct = productRepository.getProductByIdActive(lis.getIdProduct());
            if(saleProduct.getQuantity() < lis.getQuantity()){
                return null;
            }
        }
        for (SalesProduct lis : sp ) {
            Sales newSale = salesRepository.save(new Sales(lis.getIdProduct()));
            Date fecha = new Date();
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);
            calendario.add(Calendar.HOUR_OF_DAY, 3);
            Date nuevaFecha = calendario.getTime();
            lis.setSaleProductDate(nuevaFecha);
            if(saleId==0){
                saleId=newSale.getId();
            }
            lis.setIdSale(saleId);
            Product saleProduct = productRepository.getProductById(lis.getIdProduct());
            int newQuantity = saleProduct.getQuantity() - lis.getQuantity();
            saleProduct.setQuantity(newQuantity);
            SalesProduct newSaleProduct = repository.save(lis);
        }
        return sp;
    }

    public List<SalesProduct> saveDataFromCSVFile() throws IOException {
		return  parseCSVFile();
		
	}

	@SuppressWarnings("null")
	private List<SalesProduct> parseCSVFile() throws IOException {
		List<String[]> data = new ArrayList<>();
		InputStream inputStream = new FileInputStream("src/csv/Products.csv");



	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	      
			CSVParser parser = null;

			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/SalesProduct.csv"));
	        
	        for(CSVRecord row: parser) {
				@SuppressWarnings("deprecation")
				SalesProduct sp = new SalesProduct (
				Integer.parseInt(row.get("idSale")),
				Integer.parseInt(row.get("idProduct")),
				Integer.parseInt(row.get("quantity")),
		        Double.parseDouble(row.get("price")),
		        new Date(row.get("saleProductDate")),
		        row.get("typePayment")
		        );
				
				
	
				repository.save(sp);		        
	        }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	        

	    return repository.findAll();
	}

	public void getDataFromCSVFile(HttpServletResponse response) throws IOException {
		List<SalesProduct> saleProducts = repository.findAll(); // Obtenemos todos los productos desde la base de datos
        String filename = "saleProducts.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

        try (PrintWriter writer = response.getWriter()) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT

                    .withHeader("idSale", "idProduct", "quantity", "price", "saleProductDate", "typePayment", "active", "register"));
            for (SalesProduct salesProduct : saleProducts) {
                csvPrinter.printRecord(
                		salesProduct.getIdSale(),
                        salesProduct.getIdProduct(),
                        salesProduct.getQuantity(),
                        salesProduct.getPrice(),
                        salesProduct.getSaleProductDate(),
                        salesProduct.getTypePayment(),
                        salesProduct.getActive(),
                        salesProduct.getRegister()
                );
            }
            csvPrinter.flush();
        }
	}
}
