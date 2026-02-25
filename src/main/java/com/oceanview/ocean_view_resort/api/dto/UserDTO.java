package com.oceanview.ocean_view_resort.api.dto;

import java.io.Serializable;

/**
 * DTO for User Authentication and Authorization.
 * Handles Admin, Receptionist, and Staff login data.
 */
public class UserDTO implements Serializable {
    private String userId;
    private String username;
    private String password; // Used only for login/signup operations
    private String role;     // Stores the role (ADMIN, RECEPTIONIST, STAFF)
    private String fullName;

    public UserDTO() {}

    public UserDTO(String userId, String username, String password, String role, String fullName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }

    // Getters and Setters [cite: 2026-02-14]
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
}
