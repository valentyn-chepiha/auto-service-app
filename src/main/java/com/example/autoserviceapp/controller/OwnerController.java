package com.example.autoserviceapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.autoserviceapp.dto.OrderResponseDto;
import com.example.autoserviceapp.dto.OwnerRequestDto;
import com.example.autoserviceapp.dto.OwnerResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
@AllArgsConstructor
public class OwnerController {

    private EntityService<Owner, Long> ownerService;
    private RequestMapper<Owner, OwnerRequestDto> ownerRequestMapper;
    private ResponseMapper<Owner, OwnerResponseDto> ownerResponseMapper;
    private ResponseMapper<Order, OrderResponseDto> orderResponseMapper;

    @PostMapping
    public OwnerResponseDto createOwner(@RequestBody OwnerRequestDto requestDto) {
        return ownerResponseMapper.toDto(ownerService.add(ownerRequestMapper.toEntity(requestDto)));
    }

    @PutMapping
    public OwnerResponseDto updateOwner(@RequestParam(name = "id") Long id,
                                        @RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerRequestMapper.toEntity(requestDto);
        owner.setId(id);
        return ownerResponseMapper.toDto(ownerService.update(owner));
    }

    @GetMapping
    public List<OrderResponseDto> getOrders(@RequestParam(name = "id") Long id) {
        return ownerService.get(id).get().getOrders().stream()
                .map(o -> orderResponseMapper.toDto(o))
                .collect(Collectors.toList());
    }
}
