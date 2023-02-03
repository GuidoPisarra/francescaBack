package com.francesca.francescabackspring.DTO;

public class OneProductDTO {
    private int id;

    private String description;

    private float priceCost;

    private float saleCost;

    private int quantity;

    private int idProveedor;

    private String code;

    private String size;

    public OneProductDTO(int id, String description, float priceCost, float saleCost, int quantity, int idProveedor, String code, String size) {
        this.id = id;
        this.description = description;
        this.priceCost = priceCost;
        this.saleCost = saleCost;
        this.quantity = quantity;
        this.idProveedor = idProveedor;
        this.code = code;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(float priceCost) {
        this.priceCost = priceCost;
    }

    public float getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(float saleCost) {
        this.saleCost = saleCost;
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
                ", priceCost=" + priceCost +
                ", saleCost=" + saleCost +
                ", quantity=" + quantity +
                ", idProveedor=" + idProveedor +
                ", code='" + code + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
