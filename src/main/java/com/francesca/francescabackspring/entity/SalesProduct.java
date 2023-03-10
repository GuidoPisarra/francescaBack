package com.francesca.francescabackspring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class SalesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalesProduct;

    @Column
    private int idSale;

    @Column
    private int idProduct;

    @Column
    private int quantity;

    @Column
    private double price;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date SaleProductDate;

    @Column
    private String typePayment;
    
    @Column 
    private int active;
    
    @Column 
    private int register;
    
    

    public SalesProduct(int idSale, int idProduct, int quantity, double price, Date saleProductDate, String typePayment) {
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
        this.SaleProductDate = saleProductDate;
        this.typePayment = typePayment;
        this.active = 0;
        this.register = 0;
    }

    public SalesProduct() {
    }

    public int getIdSalesProduct() {
        return idSalesProduct;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Date getSaleProductDate() {
        return SaleProductDate;
    }

    public void setSaleProductDate(Date saleProductDate) {
        SaleProductDate = saleProductDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "SalesProduct [idSalesProduct=" + idSalesProduct + ", idSale=" + idSale + ", idProduct=" + idProduct
				+ ", quantity=" + quantity + ", price=" + price + ", SaleProductDate=" + SaleProductDate
				+ ", typePayment=" + typePayment + ", active=" + active + ", register=" + register + "]";
	}

	

   
}
