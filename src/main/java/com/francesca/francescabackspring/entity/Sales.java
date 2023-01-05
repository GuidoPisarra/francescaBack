package com.francesca.francescabackspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

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
    private float totalPriceSale;

    public Sales(int idProduct, Date saleDay, float totalPriceSale) {
        this.idProduct = idProduct;
        this.saleDay = saleDay;
        this.totalPriceSale = totalPriceSale;
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

    public float getTotalPriceSale() {
        return totalPriceSale;
    }

    public void setTotalPriceSale(float totalPriceSale) {
        this.totalPriceSale = totalPriceSale;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "idProduct=" + idProduct +
                ", saleDay=" + saleDay +
                ", totalPriceSale=" + totalPriceSale +
                '}';
    }


}