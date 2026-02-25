package com.oceanview.ocean_view_resort.model;

public class Admin extends User {
    private String adminLevel;

    public Admin(String userId, String username, String password, String fullName, String adminLevel) {
        // Constructor Chaining: Passing 6 arguments to User
        super(userId, username, password, "ADMIN", fullName, "ACTIVE");
        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() { return adminLevel; }
    public void setAdminLevel(String adminLevel) { this.adminLevel = adminLevel; }
}