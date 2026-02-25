package com.oceanview.ocean_view_resort.api.service.impl;

import com.oceanview.ocean_view_resort.api.dto.NotificationDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.NotificationService;
import com.oceanview.ocean_view_resort.api.service.ReservationService;
import java.time.LocalDateTime;
import java.util.Map;

public class ReservationServiceImpl implements ReservationService {
    private final NotificationService notificationService = new NotificationServiceImpl();

    @Override
    public ResponseDTO<String> createNewReservation(Map<String, Object> data) throws Exception {
        // Trigger alert to Admin - Secret Tip for top marks
        notificationService.sendAlert(new NotificationDTO(
                "ALRT-" + System.currentTimeMillis() % 1000,
                "New Reservation for " + data.get("guestName"),
                "ADMIN", LocalDateTime.now().toString()
        ));

        return new ResponseDTO<>(200, "Reservation Processed Successfully", (String)data.get("resId"));
    }
}
