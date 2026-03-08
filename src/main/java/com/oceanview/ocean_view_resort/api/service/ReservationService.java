package com.oceanview.ocean_view_resort.api.service;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import java.util.Map;

public interface ReservationService {
    ResponseDTO<String> createNewReservation(Map<String, Object> data) throws Exception;
}
