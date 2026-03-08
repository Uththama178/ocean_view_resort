package com.oceanview.ocean_view_resort.api.service;

import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;

public interface ReportService {
    ResponseDTO<Double> getMonthlyIncome(int month, int year);
}
