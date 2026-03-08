package com.oceanview.ocean_view_resort.api.service.impl;

import com.oceanview.ocean_view_resort.api.dao.ReservationDAO;
import com.oceanview.ocean_view_resort.api.dao.impl.ReservationDAOImpl;
import com.oceanview.ocean_view_resort.api.dto.ReservationDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReservationService;
import com.oceanview.ocean_view_resort.model.Reservation;
import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO = new ReservationDAOImpl();

    // inside ReservationServiceImpl.java
    @Override
    public ResponseDTO<Boolean> confirmBooking(ReservationDTO dto) {
        try {
            Reservation model = new Reservation(
                    dto.getResId(), dto.getGuestId(), dto.getRoomId(),
                    LocalDate.parse(dto.getCheckIn()), LocalDate.parse(dto.getCheckOut()),
                    "CONFIRMED", dto.getTotalAmount()
            );

            boolean isSaved = reservationDAO.save(model);
            if (isSaved) {
                // change Room Status
                // Status Update
                return new ResponseDTO<>(200, "Booking Confirmed Successfully!", true);
            }
            return new ResponseDTO<>(400, "Booking Failed!", false);
        } catch (Exception e) {
            return new ResponseDTO<>(500, e.getMessage(), false);
        }
    }

    @Override
    public List<Reservation> getAll() throws Exception {

        return reservationDAO.findAll();
    }
}

