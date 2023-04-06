package com.example.autoserviceapp.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class DetailResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
}
