package com.oceanview.ocean_view_resort.api.service.impl;

import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReportService;
import com.oceanview.ocean_view_resort.api.dao.ReportDAO;
import com.oceanview.ocean_view_resort.api.dao.impl.ReportDAOImpl;

public class ReportServiceImpl implements ReportService {
    private final ReportDAO reportDAO = new ReportDAOImpl();

    @Override
    public ResponseDTO<Double> getMonthlyIncome(int month, int year) {
        try {
            double income = reportDAO.getMonthlyIncome(month, year);
            return new ResponseDTO<>(200, "Success", income); //
        } catch (Exception e) {
            return new ResponseDTO<>(500, "Error: " + e.getMessage(), null);
        }
    }
}