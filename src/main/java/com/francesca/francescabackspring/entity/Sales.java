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


    public Sales(int idProduct) {
        this.idProduct = idProduct;
    }

    public Sales() {

    }

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }


    @Override
    public String toString() {
        return "Sales{" +
                "idProduct=" + idProduct +
                '}';
    }
}