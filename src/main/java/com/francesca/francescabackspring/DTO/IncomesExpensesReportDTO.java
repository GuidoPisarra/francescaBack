package com.francesca.francescabackspring.DTO;

public class IncomesExpensesReportDTO {

    private float incomes;

    private float egress;

    private float diference;

    public IncomesExpensesReportDTO(float incomes, float egress, float diference) {
        this.incomes = incomes;
        this.egress = egress;
        this.diference = diference;
    }

    public IncomesExpensesReportDTO() {
    }

    public float getIncomes() {
        return incomes;
    }

    public void setIncomes(float incomes) {
        this.incomes = incomes;
    }

    public float getEgress() {
        return egress;
    }

    public void setEgress(float egress) {
        this.egress = egress;
    }

    public float getDiference() {
        return diference;
    }

    public void setDiference(float diference) {
        this.diference = diference;
    }

    @Override
    public String toString() {
        return "IncomesExpensesReportDTO{" +
                "incomes=" + incomes +
                ", egress=" + egress +
                ", diference=" + diference +
                '}';
    }
}
