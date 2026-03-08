package com.oceanview.ocean_view_resort.api.service;

import com.oceanview.ocean_view_resort.api.dto.ReservationDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.model.Reservation;

import java.util.List;

public interface ReservationService {
    // Using ReservationDTO instead of Map eliminates the mismatch.
    ResponseDTO<Boolean> confirmBooking(ReservationDTO dto) throws Exception;
    List<Reservation> getAll() throws Exception;
}

