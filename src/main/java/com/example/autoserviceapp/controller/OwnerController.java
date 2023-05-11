package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.OrderResponseDto;
import com.example.autoserviceapp.dto.OwnerRequestDto;
import com.example.autoserviceapp.dto.OwnerResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
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
    private BaseService<Owner, Long> ownerService;
    private RequestMapper<Owner, OwnerRequestDto> ownerRequestMapper;
    private ResponseMapper<Owner, OwnerResponseDto> ownerResponseMapper;
    private ResponseMapper<Order, OrderResponseDto> orderResponseMapper;

    @PostMapping
    @ApiOperation(value = "Add new owner car to DB", notes = "Return new owner with id")
    public OwnerResponseDto createOwner(@RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerRequestMapper.toModel(requestDto);
        return ownerResponseMapper.toDto(ownerService.add(owner));
    }

    @PutMapping
    @ApiOperation(value = "Update info about owner in DB",
            notes = "Return owner from DB after update")
    public OwnerResponseDto updateOwner(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Owner id") Long id,
            @RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerRequestMapper.toModel(requestDto);
        owner.setId(id);
        return ownerResponseMapper.toDto(ownerService.update(owner));
    }

    @GetMapping
    @ApiOperation(value = "Get list of orders", notes = "Return list orders for current owner")
    public List<OrderResponseDto> getOrders(@RequestParam(name = "id")
                                            @ApiParam(name = "id", value = "Owner id") Long id) {
        return ownerService.get(id).get().getOrders().stream()
                .map(o -> orderResponseMapper.toDto(o))
                .collect(Collectors.toList());
    }
}
