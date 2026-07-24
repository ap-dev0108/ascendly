package com.example.worklens.dto;

public class ApiResponse<T> {
    private boolean is_success;
    private String message;
    private T data;

    public ApiResponse(boolean success, String message, T data) {
        this.is_success = success;
        this.message = message;
        this.data = data;
    }

    //GETTER
    public boolean getIsSuccess() {
        return is_success;
    }
    public String getMessage() {
        return message;
    }
    public T getData() {
        return data;
    }

    //SETTER
    public void setIsSuccess(boolean is_success) {
        this.is_success = is_success;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(T Data) {
        this.data = Data;
    }
}
