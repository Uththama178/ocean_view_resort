package com.oceanview.ocean_view_resort.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String username;
    private String password;
    private String role;
    private String fullName;
    private String status;

    public User() {}

    public User(String userId, String username, String password, String role, String fullName, String status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.status = status;
    }

    // Encapsulation: Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}