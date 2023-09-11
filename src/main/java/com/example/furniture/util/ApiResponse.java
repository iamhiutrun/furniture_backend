package com.example.furniture.util;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private String message;
    private int status;
    private T data;

    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }

    public ApiResponse(String message, HttpStatus status, T data) {
        this.message = message;
        this.status = status.value();
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}