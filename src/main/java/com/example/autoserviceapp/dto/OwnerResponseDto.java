package com.example.autoserviceapp.dto;

import java.util.List;
import lombok.Data;

@Data
public class OwnerResponseDto {
    private Long id;
    private String name;
    private List<Long> carIds;
    private List<Long> orderIds;
}
