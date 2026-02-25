package com.oceanview.ocean_view_resort.api.dto;

/**
 * Standardized Response DTO as per Class Diagram.
 * Used to communicate with UI regarding success/failure of operations.
 */
public class ResponseDTO {
    private int statusCode; // 200 for Success, 400/500 for Errors
    private String message;  // Success message or Error description
    private Object data;    // Any DTO object (UserDTO, GuestDTO, etc.)

    public ResponseDTO() {}

    public ResponseDTO(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
