package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class ReportSalesDay {

    private int idSaleProduct;

    private int idProduct;

    private int idSale;

    private String descriptionProduct;

    private int quantity;

    private double amount;

    private Date date;

    private String typePayment;

    public ReportSalesDay(int idSaleProduct, int idProduct, int idSale, String descriptionProduct, int quantity, double amount, Date date, String typePayment) {
        this.idSaleProduct = idSaleProduct;
        this.idProduct = idProduct;
        this.idSale = idSale;
        this.descriptionProduct = descriptionProduct;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
        this.typePayment = typePayment;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
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
                ", typePayment='" + typePayment + '\'' +
                '}';
    }
}
