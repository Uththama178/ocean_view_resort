package com.oceanview.ocean_view_resort.api.dto;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    private int statusCode;
    private String message;
    private T data;

    public ResponseDTO() {}

    public ResponseDTO(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    // solve getCode() error
    public int getCode() { return statusCode; }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
