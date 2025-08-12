package com.ayman.nindemo.model.dto.request;

import com.ayman.nindemo.validation.annotation.ValidateNin;
import lombok.Data;

    import javax.validation.constraints.NotNull;

@Data
public class UpdateNinRequest {
    @NotNull(message = "The national identification number can not be null")
    private Long ninId;

    @ValidateNin
    private String nin;
}
