package com.francesca.francescabackspring.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;

    @Column
    private String description;

    @Column
    private float price;

    @Column
    private String size;

    @Column
    private int quantity;

    @Column
    private String code;

    public Product(String description, float price, String size, int quantity, String code) {
        this.description = description;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.code = code;
    }

    public Product() {

    }

    public int getId() {
        return id_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id_product +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", quantity=" + quantity +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id_product == product.id_product && code == product.code;
    }


}
