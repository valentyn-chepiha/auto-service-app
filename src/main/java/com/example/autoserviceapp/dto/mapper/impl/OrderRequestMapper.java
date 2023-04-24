package com.example.autoserviceapp.dto.mapper.impl;

import java.util.HashSet;
import java.util.Set;
import com.example.autoserviceapp.dto.OrderRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.EntityOperationService;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRequestMapper implements RequestMapper<Order, OrderRequestDto> {

    private EntityService<Car, Long> carService;
    private EntityOperationService<Detail, Long> detailService;
    private EntityOperationService<Operation, Long> operationService;
    private EntityService<Owner, Long> ownerService;

    @Override
    public Order toEntity(OrderRequestDto dto) {
        Order entity = new Order();
        entity.setCar(carService.get(dto.getCarId()).get());
        entity.setDescription(dto.getDescription());
        entity.setDateStart(dto.getDateStart());
        Set<Long> operationIds = new HashSet<>(dto.getOperationIds());
        entity.setOperations(operationService.getAllByIds(operationIds));
        Set<Long> detailIds = new HashSet<>(dto.getDetailIds());
        entity.setDetails(detailService.getAllByIds(detailIds));
        entity.setStatus(Order.StatusService.valueOf(dto.getStatusName()));
        entity.setTotal(dto.getTotal());
        entity.setDateEnd(dto.getDateEnd());
        entity.setOwner(ownerService.get(dto.getOwnerId()).get());
        return entity;
    }
}
