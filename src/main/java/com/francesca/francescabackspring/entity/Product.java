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
    private int id;

    @Column
    private String description;

    @Column
    private float costPrice;

    @Column
    private float salePrice;

    @Column
    private int quantity;

    @Column
    private int idProveedor;

    @Column
    private String code;

    @Column
    private String size;


    public Product(String description, float costPrice, float salePrice, int quantity, int idProveedor, String code, String size) {
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.idProveedor = idProveedor;
        this.code = code;
        this.size = size;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", quantity=" + quantity +
                ", idProveedor=" + idProveedor +
                ", code='" + code + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
