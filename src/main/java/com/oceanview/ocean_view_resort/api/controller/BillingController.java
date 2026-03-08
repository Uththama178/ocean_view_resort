package com.oceanview.ocean_view_resort.api.controller;

import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.BillingService;
import com.oceanview.ocean_view_resort.api.service.impl.BillingServiceImpl;

public class BillingController {
    private final BillingService billingService = new BillingServiceImpl();


    public ResponseDTO<Double> calculateFinalBill(double rate, int nights) {
        try {

            return billingService.calculateFinalBill(rate, nights);
        } catch (Exception e) {

            return new ResponseDTO<>(500, "Billing Error: " + e.getMessage(), 0.0);
        }
    }
}