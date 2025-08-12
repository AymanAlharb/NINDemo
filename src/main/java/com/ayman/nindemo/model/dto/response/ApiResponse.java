package com.ayman.nindemo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse {
    private String message;

    public ApiResponse(String message){
        this.message = message;
    }
}
