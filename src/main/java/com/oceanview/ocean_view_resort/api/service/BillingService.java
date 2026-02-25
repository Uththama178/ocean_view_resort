package com.oceanview.ocean_view_resort.api.service;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;

public interface BillingService {
    ResponseDTO<Double> calculateFinalBill(double ratePerNight, int totalNights);
}
