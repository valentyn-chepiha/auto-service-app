package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.OrderRequestDto;
import com.example.autoserviceapp.dto.OrderResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.OrderService;
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
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto dto) {
        return orderResponseMapper.toDto(orderService.add(orderRequestMapper.toModel(dto)));
    }

    @PostMapping("/{id}")
    public OrderResponseDto addDetail(@PathVariable Long id,
                                     @RequestParam(name = "id_detail") Long idDetail) {
        return orderResponseMapper.toDto(orderService.addDetail(id, idDetail));
    }

    @PutMapping
    public OrderResponseDto updateOrder(@RequestParam(name = "id") Long id,
                                        @RequestBody OrderRequestDto dto) {
        Order order = orderRequestMapper.toModel(dto);
        order.setId(id);
        return orderResponseMapper.toDto(orderService.update(order));
    }

    @PutMapping("/status")
    public OrderResponseDto updateOrderStatus(@RequestParam(name = "id") Long id,
                                              @RequestParam(name = "status") String status) {
        return orderResponseMapper.toDto(orderService.updateStatus(id, status));
    }

    @GetMapping
    public BigDecimal getTotal(@RequestParam(name = "id") Long id) {
        return orderService.calculateOrder(id);
    }
}
