package com.oceanview.ocean_view_resort.api.service.impl;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.BillingService;

public class BillingServiceImpl implements BillingService {
    @Override
    public ResponseDTO<Double> calculateFinalBill(double rate, int nights) {
        if (nights < 1) return new ResponseDTO<>(400, "Invalid duration", 0.0);
        double total = rate * nights;
        return new ResponseDTO<>(200, "Calculation Successful", total);
    }
}
