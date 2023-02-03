package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class SalesDTO {

    private int id;
    private int id_product;
    private int quantity;
    private double amount;


    public SalesDTO(int id, int id_product, int quantity, double amount) {
        this.id = id;
        this.id_product = id_product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SalesDTO{" +
                "id=" + id +
                ", id_product=" + id_product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}