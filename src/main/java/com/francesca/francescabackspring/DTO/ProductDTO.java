package com.francesca.francescabackspring.DTO;

public class ProductDTO {
    private int id;
    private long amount;

    public ProductDTO(int id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_product) {
        this.id = id_product;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id_product=" + id +
                ", amount=" + amount +
                '}';
    }
}