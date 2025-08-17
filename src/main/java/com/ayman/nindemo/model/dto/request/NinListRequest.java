package com.ayman.nindemo.model.dto.request;

import com.ayman.nindemo.validation.annotation.ValidateNin;
import lombok.Data;

import java.util.List;
@Data
public class NinListRequest {
    private List<@ValidateNin String> nins;
}
