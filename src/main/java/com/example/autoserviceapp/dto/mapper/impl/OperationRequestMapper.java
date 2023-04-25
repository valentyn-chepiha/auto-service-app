package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OperationRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.EntityMasterService;
import com.example.autoserviceapp.service.EntityOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OperationRequestMapper implements RequestMapper<Operation, OperationRequestDto> {
    private EntityMasterService<Master, Long> masterService;
    private EntityOrderService<Order, Long> orderService;

    @Override
    public Operation toEntity(OperationRequestDto dto) {
        Operation entity = new Operation();
        entity.setCost(dto.getCost());
        entity.setMaster(masterService.get(dto.getMasterId()).get());
        entity.setOrder(orderService.get(dto.getOrderId()).get());
        entity.setStatus(Operation.StatusPaid.valueOf(dto.getStatusName()));
        return entity;
    }
}
