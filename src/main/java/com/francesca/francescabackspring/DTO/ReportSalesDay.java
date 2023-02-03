package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class ReportSalesDay {

    private int id;

    private int idProduct;

    private int idSale;

    private Date date;

    private float monto;

    public ReportSalesDay(int id, int idProduct, int idSale, Date date, float monto) {
        this.id = id;
        this.idProduct = idProduct;
        this.idSale = idSale;
        this.date = date;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ReportSalesDay{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idSale=" + idSale +
                ", date=" + date +
                ", monto=" + monto +

                '}';
    }
}
