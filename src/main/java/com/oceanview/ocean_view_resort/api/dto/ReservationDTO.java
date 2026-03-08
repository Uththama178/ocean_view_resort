package com.oceanview.ocean_view_resort.api.dto;

import java.io.Serializable;

/**

 * Data Transfer Object for Reservation logic.
 */
public class ReservationDTO implements Serializable {
    private String resId;
    private String guestId;
    private String guestName;
    private String roomId;
    private String checkIn;
    private String checkOut;
    private double totalAmount;

    // Default Constructor
    public ReservationDTO() {}


    public ReservationDTO(String resId, String guestId, String guestName, String roomId, String checkIn, String checkOut, double totalAmount) {
        this.resId = resId;
        this.guestId = guestId;
        this.guestName = guestName;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getResId() { return resId; }
    public void setResId(String resId) { this.resId = resId; }

    public String getGuestId() { return guestId; }
    public void setGuestId(String guestId) { this.guestId = guestId; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }

    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }


    @Override
    public String toString() {
        return "ReservationDTO{" +
                "resId='" + resId + '\'' +
                ", guestId='" + guestId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
