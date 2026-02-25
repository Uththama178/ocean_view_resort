package com.oceanview.ocean_view_resort.model;
import java.io.Serializable;

public class Room implements Serializable {
    private String roomId;
    private String type;
    private double price;
    private String status;

    public Room() {}
    public Room(String roomId, String type, double price, String status) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    // 💡 Getters
    public String getRoomId() { return roomId; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
}