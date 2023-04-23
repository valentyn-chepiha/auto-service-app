package com.example.autoserviceapp.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OperationRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal cost;
    private String statusName;
}
