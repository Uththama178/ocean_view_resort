package com.oceanview.ocean_view_resort.model;
import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {
    private String resId;
    private String guestId;
    private String roomId;
    private Date checkIn;
    private Date checkOut;
    private String status;

    public Reservation() {}
    public Reservation(String resId, String guestId, String roomId, Date checkIn, Date checkOut, String status) {
        this.resId = resId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    // 💡 Getters
    public String getResId() { return resId; }
    public String getGuestId() { return guestId; }
    public String getRoomId() { return roomId; }
    public Date getCheckIn() { return checkIn; }
    public Date getCheckOut() { return checkOut; }
    public String getStatus() { return status; }
}
