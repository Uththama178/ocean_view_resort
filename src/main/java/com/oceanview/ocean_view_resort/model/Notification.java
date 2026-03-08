package com.oceanview.ocean_view_resort.model;

import java.sql.Timestamp;

public class Notification {
    private String notifId;
    private String message;
    private String receiverRole; // ADMIN, STAFF, or RECEPTIONIST
    private Timestamp timestamp;
    private boolean isRead;

    public Notification() {}

    public Notification(String notifId, String message, String receiverRole, Timestamp timestamp, boolean isRead) {
        this.notifId = notifId;
        this.message = message;
        this.receiverRole = receiverRole;
        this.timestamp = timestamp;
        this.isRead = isRead;
    }

    // Getters and Setters
    public String getNotifId() { return notifId; }
    public void setNotifId(String notifId) { this.notifId = notifId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getReceiverRole() { return receiverRole; }
    public void setReceiverRole(String receiverRole) { this.receiverRole = receiverRole; }
    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}