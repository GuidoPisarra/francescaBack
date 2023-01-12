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
    private int quantity;
    @Column
    private double price;

    public Sales(int idProduct, int quantity, double price) {
        this.idProduct = idProduct;
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
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}