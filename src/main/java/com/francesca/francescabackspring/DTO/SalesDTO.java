package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class SalesDTO {
    private int id_product;
    private int quantity;
    private double amount;

    private Date day;


    public SalesDTO(int id_product, int quantity, double amount, String day) {
        this.id_product = id_product;
        this.quantity = quantity;
        this.amount = amount;
        this.day = new Date(day);
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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
                "id_product=" + id_product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", day=" + day +
                '}';
    }
}