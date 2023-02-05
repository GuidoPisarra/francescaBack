package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class ReportSalesDay {

    private int idSaleProduct;

    private int idProduct;

    private int idSale;

    private String descriptionProduct;

    private int quantity;

    private float amount;

    private Date date;

    public ReportSalesDay(int idSaleProduct, int idProduct, int idSale, String descriptionProduct, int quantity, float amount, Date date) {
        this.idSaleProduct = idSaleProduct;
        this.idProduct = idProduct;
        this.idSale = idSale;
        this.descriptionProduct = descriptionProduct;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
    }

    public ReportSalesDay() {
    }

    public int getIdSaleProduct() {
        return idSaleProduct;
    }

    public void setIdSaleProduct(int idSaleProduct) {
        this.idSaleProduct = idSaleProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReportSalesDay{" +
                "idSaleProduct=" + idSaleProduct +
                ", idProduct=" + idProduct +
                ", idSale=" + idSale +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
