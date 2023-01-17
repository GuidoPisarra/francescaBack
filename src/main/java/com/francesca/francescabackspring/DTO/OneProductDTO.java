package com.francesca.francescabackspring.DTO;

public class OneProductDTO {
    private int id_product;

    private String description;

    private float price;

    private char size;

    private int quantity;

    private String code;

    public OneProductDTO(int id_product, String description, float price, char size, int quantity, String code) {
        this.id_product = id_product;
        this.description = description;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.code = code;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
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

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OneProductDTO{" +
                "id_product=" + id_product +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", quantity=" + quantity +
                ", code=" + code +
                '}';
    }
}
