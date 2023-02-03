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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date SaleProductDate;

    public SalesProduct( int idSale, int idProduct, Date saleProductDate) {
        this.idSale = idSale;
        this.idProduct = idProduct;
        SaleProductDate = saleProductDate;
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

    @Override
    public String toString() {
        return "SalesProduct{" +
                "idSalesProduct=" + idSalesProduct +
                ", idSale=" + idSale +
                ", idProduct=" + idProduct +
                ", SaleProductDate='" + SaleProductDate + '\'' +
                '}';
    }
}
