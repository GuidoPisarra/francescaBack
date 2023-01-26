package com.francesca.francescabackspring.entity;

import javax.persistence.*;

@Entity
@Table(name="Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String description;

    @Column
    private float price;

    @Column
    private int id_sucursal;

    public Expense(String description, float price, int id_sucursal) {
        this.description = description;
        this.price = price;
        this.id_sucursal = id_sucursal;
    }

    public Expense() {

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", id_sucursal=" + id_sucursal +
                '}';
    }
}