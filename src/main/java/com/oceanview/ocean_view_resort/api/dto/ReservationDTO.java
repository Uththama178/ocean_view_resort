package com.oceanview.ocean_view_resort.api.dto;

import java.sql.Date;

/**
 * DTO for Handling Booking/Reservation Logic.
 * Captures duration of stay for cost computation.
 */
public class ReservationDTO {
    private String resId;
    private String guestId;
    private String roomId;
    private Date checkInDate;
    private Date checkOutDate;

    public ReservationDTO() {}

    public ReservationDTO(String resId, String guestId, String roomId, Date checkInDate, Date checkOutDate) {
        this.resId = resId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Logic: Essential for calculating number of nights
    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }

    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public String getResId() { return resId; }
    public String getRoomId() { return roomId; }
}