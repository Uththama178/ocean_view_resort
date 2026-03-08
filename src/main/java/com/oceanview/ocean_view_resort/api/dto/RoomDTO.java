package com.oceanview.ocean_view_resort.api.dto;

/**
 * DTO for Room Management.
 * Includes pricePerNight for bill calculation requirements.
 */
public class RoomDTO {
    private String roomId;
    private String roomNumber;
    private String type;
    private double pricePerNight;
    private String status; // AVAILABLE, OCCUPIED, MAINTENANCE

    public RoomDTO() {}

    public RoomDTO(String roomId, String roomNumber, String type, double pricePerNight, String status) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
