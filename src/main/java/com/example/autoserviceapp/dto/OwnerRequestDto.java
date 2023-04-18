package com.example.autoserviceapp.dto;

import java.util.List;
import lombok.Data;

@Data
public class OwnerRequestDto {
    private String name;
    private List<Long> carIds;
    private List<Long> orderIds;
}
