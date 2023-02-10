package com.francesca.francescabackspring.service;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.repository.ProductRepository;
import com.google.common.net.HttpHeaders;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

@Service
public class ProductService {

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository repository;

    public ProductService(@Qualifier("productRepository") ProductRepository repository){
        this.repository= repository;
    }

    public Product newProduct (Product p){
    	OneProductDTO prod = repository.getProductByCode(p.getCode());
        if (prod!=null){
			
	        for (Product pr : repository.getReferenceByCodeAll(prod.getCode()) ) {
	        	pr.setActivo(1);
	        	repository.save(pr);
	        	System.out.println(pr.toString());
	        }

        	
        }

        return repository.save(p);
    }

    public List<Product> getProducts(){return repository.findAllActive();}


    public void deleteProduct(int p) {
    	Product prodToDelete = repository.getById(p);
    	prodToDelete.setActivo(1);
    	repository.save(prodToDelete);
    }

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

	public List<Product> saveDataFromCSVFile() throws IOException {
		return  parseCSVFile();
		
	}

	@SuppressWarnings("null")
	private List<Product> parseCSVFile() throws IOException {
		List<String[]> data = new ArrayList<>();
		InputStream inputStream = new FileInputStream("src/csv/Products.csv");



	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	      
			CSVParser parser = null;

			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/Products.csv"));
	        
	        for(CSVRecord row: parser) {
				
				Product p = new Product (row.get("description"),
		        Float.parseFloat(row.get("costPrice")),
		        Float.parseFloat(row.get("salePrice")),
		        Integer.parseInt(row.get("quantity")),
		        Integer.parseInt(row.get("idProveedor")),
		        row.get("code"),
		        row.get("size")
		        );
				
				System.out.println(p.toString());
	
				this.newProduct(p);		        
	        }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	        

	    return repository.findAllActive();
	}

	public void getDataFromCSVFile(HttpServletResponse response) throws IOException {
		List<Product> products = repository.findAll(); // Obtenemos todos los productos desde la base de datos
        String filename = "products.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

        try (PrintWriter writer = response.getWriter()) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("description", "costPrice", "salePrice", "quantity", "idProveedor", "code", "size", "activo"));
            for (Product product : products) {
                csvPrinter.printRecord(
                        product.getDescription(),
                        product.getCostPrice(),
                        product.getSalePrice(),
                        product.getQuantity(),
                        product.getIdProveedor(),
                        product.getCode(),
                        product.getSize(),
                        product.getActivo()
                );
            }
            csvPrinter.flush();
        }
	}
}
