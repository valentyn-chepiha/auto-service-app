package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.OperationRequestDto;
import com.example.autoserviceapp.dto.OperationResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.service.OperationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation")
@AllArgsConstructor
public class OperationController {
    private ResponseMapper<Operation, OperationResponseDto> responseMapper;
    private RequestMapper<Operation, OperationRequestDto> requestMapper;
    private OperationService<Operation, Long> operationService;

    @PostMapping
    @ApiOperation(value = "Add new operation to DB", notes = "Return new operation with id")
    public OperationResponseDto createOperation(@RequestBody OperationRequestDto dto) {
        return responseMapper.toDto(operationService.add(requestMapper.toModel(dto)));
    }

    @PutMapping
    @ApiOperation(value = "Update info about operation in DB",
            notes = "Return operation from DB after update")
    public OperationResponseDto updateOperation(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Operation id") Long id,
            @RequestBody OperationRequestDto dto) {
        Operation operation = requestMapper.toModel(dto);
        operation.setId(id);
        return responseMapper.toDto(operationService.update(operation));
    }

    @PutMapping("/status")
    @ApiOperation(value = "Update status of operation in DB",
            notes = "Return operation from DB after update")
    public OperationResponseDto updateOperationStatus(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Operation id") Long id,
            @RequestParam(name = "status")
            @ApiParam(name = "status", value = "Operation status") String status) {
        Operation operation = operationService.get(id).get();
        operation.setStatus(Operation.StatusPaid.valueOf(status));
        return responseMapper.toDto(operationService.update(operation));
    }
}
