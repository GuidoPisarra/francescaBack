package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class SalesDTO {

    private int id;
    private int id_product;



    public SalesDTO(int id, int id_product) {
        this.id = id;
        this.id_product = id_product;
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

    @Override
    public String toString() {
        return "SalesDTO{" +
                "id=" + id +
                ", id_product=" + id_product +
                '}';
    }
}