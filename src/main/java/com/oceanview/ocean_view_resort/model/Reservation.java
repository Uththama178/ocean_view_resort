package com.oceanview.ocean_view_resort.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable {
    private String resId;
    private String guestId;
    private String roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String status;
    private double totalAmount; // නිවැරදි කරන ලද කොටස

    public Reservation() {}

    public Reservation(String resId, String guestId, String roomId, LocalDate checkIn, LocalDate checkOut, String status, double totalAmount) {
        this.resId = resId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getResId() { return resId; }
    public void setResId(String resId) { this.resId = resId; }
    public String getGuestId() { return guestId; }
    public void setGuestId(String guestId) { this.guestId = guestId; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public LocalDate getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
