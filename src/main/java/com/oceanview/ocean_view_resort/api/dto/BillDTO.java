package com.oceanview.ocean_view_resort.api.dto;

/**
 * DTO for Billing and Payments.
 * Holds final calculated amounts for the staff to process.
 */
public class BillDTO {
    private String billId;
    private String resId;
    private double totalAmount;
    private double discount;
    private double finalAmount;

    public BillDTO() {}

    public BillDTO(String billId, String resId, double totalAmount, double discount, double finalAmount) {
        this.billId = billId;
        this.resId = resId;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }
}
