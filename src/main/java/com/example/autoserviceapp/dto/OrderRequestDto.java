package com.example.autoserviceapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Long carId;
    private String description;
    private LocalDate dateStart;
    private List<Long> operationIds;
    private List<Long> detailIds;
    private String statusName;
    private BigDecimal total;
    private LocalDate dateEnd;
    private Long ownerId;
}
