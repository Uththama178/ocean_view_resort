package com.oceanview.ocean_view_resort.model;

public class Report {
    private String reportId;
    private String type; // e.g., "INCOME", "OCCUPANCY"
    private double totalValue;
    private String generatedDate;

    public Report() {}
    public Report(String reportId, String type, double totalValue, String generatedDate) {
        this.reportId = reportId;
        this.type = type;
        this.totalValue = totalValue;
        this.generatedDate = generatedDate;
    }

}