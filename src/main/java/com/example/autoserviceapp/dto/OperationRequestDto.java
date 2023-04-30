package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OperationRequestDto {
    @ApiModelProperty(notes = "Order id", example = "1")
    private Long orderId;
    @ApiModelProperty(notes = "Master id", example = "1")
    private Long masterId;
    @ApiModelProperty(notes = "Cost operation", example = "150")
    private BigDecimal cost;
    @ApiModelProperty(notes = "Status operation", example = "paid, not_paid")
    private String statusName;
}
