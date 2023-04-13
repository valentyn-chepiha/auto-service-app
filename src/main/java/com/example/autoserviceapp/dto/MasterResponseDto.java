package com.example.autoserviceapp.dto;

import java.util.List;
import com.example.autoserviceapp.model.Service;
import lombok.Data;

@Data
public class MasterResponseDto {
    private Long id;
    private String pib;
    private List<Service> services;
}
