package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class DetailResponseDto {
    @ApiModelProperty(notes = "Detail id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "Detail name", example = "Wheel")
    private String name;
    @ApiModelProperty(notes = "Detail price", example = "21.5")
    private BigDecimal price;
}
