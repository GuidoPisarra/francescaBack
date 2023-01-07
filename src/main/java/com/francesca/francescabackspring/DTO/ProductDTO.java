package com.francesca.francescabackspring.DTO;

public class ProductDTO {
    private int id_product;
    private long amount;

    public ProductDTO(int id_product, long amount) {
        this.id_product = id_product;
        this.amount = amount;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
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
                "id_product=" + id_product +
                ", amount=" + amount +
                '}';
    }
}