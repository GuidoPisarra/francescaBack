package com.francesca.francescabackspring.DTO;

import javax.persistence.Column;

public class OneExpenseDTO {

    private int id;

    private String description;

    private float price;

    private int id_sucursal;

    public OneExpenseDTO(int id, String description, float price, int id_sucursal) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.id_sucursal = id_sucursal;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    @Override
    public String toString() {
        return "OneExpenseDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", id_sucursal=" + id_sucursal +
                '}';
    }
}
