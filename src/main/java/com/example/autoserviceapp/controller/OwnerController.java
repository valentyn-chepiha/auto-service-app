package com.example.autoserviceapp.controller;

import java.util.List;
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
    private RequestMapper<Owner, OwnerRequestDto> requestMapper;
    private ResponseMapper<Owner, OwnerResponseDto> responseMapper;
    @PostMapping
    public OwnerResponseDto createOwner(@RequestBody OwnerRequestDto requestDto) {
        return responseMapper.toDto(ownerService.add(requestMapper.toEntity(requestDto)));
    }

    @PutMapping
    public OwnerResponseDto updateOwner(@RequestParam(name = "id") Long id,
                                        @RequestBody OwnerRequestDto requestDto) {
        Owner owner = requestMapper.toEntity(requestDto);
        owner.setId(id);
        return responseMapper.toDto(ownerService.update(owner));
    }

    // todo
    //      change Order to OrderResponseDto
    @GetMapping
    public List<Order> getOrders(@RequestParam(name = "id") Long id) {
        return ownerService.get(id).get().getOrders();
    }
}
