package com.ayman.nindemo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class NinResponse {
    private Long id;
    private String nin;
}
