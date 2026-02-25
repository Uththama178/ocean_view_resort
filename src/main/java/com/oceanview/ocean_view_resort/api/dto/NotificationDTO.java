package com.oceanview.ocean_view_resort.api.dto;

import java.io.Serializable;

public class NotificationDTO implements Serializable {
    private String notifId;
    private String message;
    private String receiverRole;
    private String timestamp; // String format for UI display

    public NotificationDTO() {}

    public NotificationDTO(String notifId, String message, String receiverRole, String timestamp) {
        this.notifId = notifId;
        this.message = message;
        this.receiverRole = receiverRole;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getNotifId() { return notifId; }
    public void setNotifId(String notifId) { this.notifId = notifId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getReceiverRole() { return receiverRole; }
    public void setReceiverRole(String receiverRole) { this.receiverRole = receiverRole; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
