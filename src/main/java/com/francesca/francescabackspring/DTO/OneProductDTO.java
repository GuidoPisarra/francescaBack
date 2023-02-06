package com.francesca.francescabackspring.DTO;

public class OneProductDTO {
    private int id;

    private String description;

    private float costPrice;

    private float salePrice;

    private int quantity;

    private int idProveedor;

    private String code;

    private String size;

    public OneProductDTO(int id, String description, float costPrice, float salePrice, int quantity, int idProveedor, String code, String size) {
        this.id = id;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.idProveedor = idProveedor;
        this.code = code;
        this.size = size;
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

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OneProductDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", quantity=" + quantity +
                ", idProveedor=" + idProveedor +
                ", code='" + code + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
