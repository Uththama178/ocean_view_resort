package com.oceanview.ocean_view_resort.model;

public class Staff extends User {
    private String department;

    public Staff() { super(); }

    public Staff(String userId, String username, String password, String fullName, String department) {
        super(userId, username, password, "STAFF", fullName, "ACTIVE");
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}