package com.example.autoserviceapp.dto;

import java.util.List;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Order;
import lombok.Data;

@Data
public class OwnerResponseDto {
    private Long id;
    private String name;
    private List<Car> cars;
    private List<Order> orders;
}

// todo:
//      ???
//    private List<CarResponseDto> cars;
//    private List<OrderResponseDto> orders;
