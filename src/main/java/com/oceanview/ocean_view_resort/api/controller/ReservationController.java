package com.oceanview.ocean_view_resort.api.controller;

import com.oceanview.ocean_view_resort.api.dto.ReservationDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReservationService;
import com.oceanview.ocean_view_resort.api.service.impl.ReservationServiceImpl;

public class ReservationController {
    // Dependency Injection using Interface
    private final ReservationService reservationService = new ReservationServiceImpl();

    public ResponseDTO<Boolean> makeReservation(ReservationDTO dto) {
        try {

            return reservationService.confirmBooking(dto);
        } catch (Exception e) {

            return new ResponseDTO<>(500, "Error: " + e.getMessage(), false);
        }
    }
}
