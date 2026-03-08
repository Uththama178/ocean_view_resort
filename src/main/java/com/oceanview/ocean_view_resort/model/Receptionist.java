package com.oceanview.ocean_view_resort.model;

public class Receptionist extends User {
    private String deskNumber;

    public Receptionist(String userId, String username, String password, String fullName, String deskNumber) {
        super(userId, username, password, "RECEPTIONIST", fullName, "ACTIVE");
        this.deskNumber = deskNumber;
    }

    public String getDeskNumber() { return deskNumber; }
    public void setDeskNumber(String deskNumber) { this.deskNumber = deskNumber; }
}