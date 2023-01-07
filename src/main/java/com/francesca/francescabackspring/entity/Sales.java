package com.francesca.francescabackspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int  idProduct;

    @Column
    private Date saleDay;

    @Column
    private int quantity;
    @Column
    private double price;

    public Sales(int idProduct, String saleDay, int quantity, double price) {
        this.idProduct = idProduct;
        this.saleDay = new Date(saleDay);
        this.quantity = quantity;
        this.price = price;
    }

    public Sales() {

    }

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Date getSaleDay() {
        return saleDay;
    }

    public void setSaleDay(Date saleDay) {
        this.saleDay = saleDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "idProduct=" + idProduct +
                ", saleDay=" + saleDay +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}