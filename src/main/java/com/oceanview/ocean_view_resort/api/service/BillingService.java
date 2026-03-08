package com.oceanview.ocean_view_resort.api.service;
import com.oceanview.ocean_view_resort.api.dto.BillDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;

public interface BillingService {
    ResponseDTO<Double> calculateFinalBill(double ratePerNight, int totalNights);
    ResponseDTO<Boolean> saveBill(BillDTO billDTO);
}


