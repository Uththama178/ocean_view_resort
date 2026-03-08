package com.oceanview.ocean_view_resort.api.dto;

public class ReportDTO {
    private String title;
    private double value;

    public ReportDTO(String title, double value) {
        this.title = title;
        this.value = value;
    }
    public String getTitle() { return title; }
    public double getValue() { return value; }
}