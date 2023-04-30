package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.OrderRequestDto;
import com.example.autoserviceapp.dto.OrderResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private ResponseMapper<Order, OrderResponseDto> orderResponseMapper;
    private RequestMapper<Order, OrderRequestDto> orderRequestMapper;
    private OrderService<Order, Long> orderService;

    @PostMapping
    @ApiOperation(value = "Add new order to DB", notes = "Return new order with id")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto dto) {
        return orderResponseMapper.toDto(orderService.add(orderRequestMapper.toModel(dto)));
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Add details to order", notes = "Return order from DB after update")
    public OrderResponseDto addDetail(
            @PathVariable @ApiParam(name = "id", value = "Order id") Long id,
            @RequestParam(name = "id_detail")
            @ApiParam(name = "id_detail", value = "Detail id") Long idDetail) {
        return orderResponseMapper.toDto(orderService.addDetail(id, idDetail));
    }

    @PutMapping
    @ApiOperation(value = "Update info about order in DB",
            notes = "Return order from DB after update")
    public OrderResponseDto updateOrder(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Order id") Long id,
            @RequestBody OrderRequestDto dto) {
        Order order = orderRequestMapper.toModel(dto);
        order.setId(id);
        return orderResponseMapper.toDto(orderService.update(order));
    }

    @PutMapping("/status")
    @ApiOperation(value = "Change status of order", notes = "Return order from DB after update")
    public OrderResponseDto updateOrderStatus(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Order id") Long id,
            @RequestParam(name = "status")
            @ApiParam(name = "status", value = "Order status") String status) {
        return orderResponseMapper.toDto(orderService.updateStatus(id, status));
    }

    @GetMapping
    @ApiOperation(value = "Get total summ", notes = "Return the order amount")
    public BigDecimal getTotal(@RequestParam(name = "id")
                                   @ApiParam(name = "id", value = "Order id") Long id) {
        return orderService.calculateOrder(id);
    }
}
