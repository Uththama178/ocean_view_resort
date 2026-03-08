package com.oceanview.ocean_view_resort.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Bill implements Serializable {
    private String billId;
    private String resId;
    private double totalAmount;
    private Timestamp billingDate;

    public Bill() {}

    public Bill(String billId, String resId, double totalAmount, Timestamp billingDate) {
        this.billId = billId;
        this.resId = resId;
        this.totalAmount = totalAmount;
        this.billingDate = billingDate;
    }

    // Encapsulation: Getters and Setters
    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }
    public String getResId() { return resId; }
    public void setResId(String resId) { this.resId = resId; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public Timestamp getBillingDate() { return billingDate; }
    public void setBillingDate(Timestamp billingDate) { this.billingDate = billingDate; }
}