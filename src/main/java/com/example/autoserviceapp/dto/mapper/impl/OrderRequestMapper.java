package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OrderRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.BaseService;
import com.example.autoserviceapp.service.OperationService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRequestMapper implements RequestMapper<Order, OrderRequestDto> {
    private BaseService<Car, Long> carService;
    private OperationService<Detail, Long> detailService;
    private OperationService<Operation, Long> operationService;
    private BaseService<Owner, Long> ownerService;

    @Override
    public Order toModel(OrderRequestDto dto) {
        Order entity = new Order();
        entity.setCar(carService.get(dto.getCarId()).get());
        entity.setDescription(dto.getDescription());
        entity.setDateStart(dto.getDateStart());

        if (dto.getOperationIds().size() > 0) {
            Set<Long> operationIds = new HashSet<>(dto.getOperationIds());
            entity.setOperations(operationService.getAllByIds(operationIds));
        } else {
            entity.setOperations(new ArrayList<>());
        }

        if (dto.getDetailIds().size() > 0) {
            Set<Long> detailIds = new HashSet<>(dto.getDetailIds());
            entity.setDetails(detailService.getAllByIds(detailIds));
        } else {
            entity.setDetails(new ArrayList<>());
        }

        entity.setStatus(Order.StatusService.valueOf(dto.getStatusName().toUpperCase()));
        entity.setTotal(dto.getTotal());
        entity.setDateEnd(dto.getDateEnd());
        entity.setOwner(ownerService.get(dto.getOwnerId()).get());
        return entity;
    }
}
