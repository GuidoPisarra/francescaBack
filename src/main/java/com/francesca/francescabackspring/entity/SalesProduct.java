package com.francesca.francescabackspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class SalesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sales_product;

    @Column
    private int id_sale;

    @Column
    private int id_product;

    @Column
    private String SaleProductDate;

    private float total;

    public SalesProduct(int id_sale, int id_product, String saleProductDate, float total) {
        this.id_sale = id_sale;
        this.id_product = id_product;
        this.SaleProductDate = saleProductDate;
        this.total = total;
    }

    public SalesProduct() {
    }

    public int getId_sales_product() {
        return id_sales_product;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getSaleProductDate() { return this.SaleProductDate;  }

    public void setSaleProductDate(String saleProductDate) {
        SaleProductDate = saleProductDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalesProduct{" +
                "id_sales_product=" + id_sales_product +
                ", id_sale=" + id_sale +
                ", id_product=" + id_product +
                ", SaleProductDate=" + SaleProductDate +
                ", total=" + total +
                '}';
    }
}
