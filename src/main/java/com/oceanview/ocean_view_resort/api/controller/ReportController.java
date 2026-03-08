package com.oceanview.ocean_view_resort.api.controller;

import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReportService; // නිවැරදි Import එක
import com.oceanview.ocean_view_resort.api.service.impl.ReportServiceImpl; // නිවැරදි Import එක

public class ReportController {
    // Connect service via Interface
    private final ReportService reportService = new ReportServiceImpl();

    public ResponseDTO<Double> getIncomeReport(int month, int year) {
        try {
            // Service layer (information))
            return reportService.getMonthlyIncome(month, year);
        } catch (Exception e) {

            return new ResponseDTO<>(500, "Error: " + e.getMessage(), null);
        }
    }
}
