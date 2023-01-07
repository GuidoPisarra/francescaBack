package com.francesca.francescabackspring.DTO;

import java.util.Date;

public class ReportSalesDay {
    private Date date;
    private long quantity;
    private double amount;

    public ReportSalesDay(Date date, long quantity, double amount) {
        this.date = date;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ReportSalesDay{" +
                "date=" + date +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
