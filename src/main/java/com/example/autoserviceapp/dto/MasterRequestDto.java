package com.example.autoserviceapp.dto;

import java.util.List;
import lombok.Data;

@Data
public class MasterRequestDto {
    private String pib;
    private List<Long> serviceIds;
}
