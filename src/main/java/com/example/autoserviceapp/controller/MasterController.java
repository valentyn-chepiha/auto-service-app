package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.MasterRequestDto;
import com.example.autoserviceapp.dto.MasterResponseDto;
import com.example.autoserviceapp.dto.OperationResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.service.MasterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master")
@RequiredArgsConstructor
public class MasterController {
    private RequestMapper<Master, MasterRequestDto> masterRequestMapper;
    private ResponseMapper<Master, MasterResponseDto> masterResponseMapper;
    private ResponseMapper<Operation, OperationResponseDto> operationResponseMapper;
    private MasterService<Master, Long> masterService;

    @PostMapping
    @ApiOperation(value = "Add new master to DB", notes = "Return new master with id")
    public MasterResponseDto createMaster(@RequestBody MasterRequestDto requestDto) {
        Master master = masterService.add(masterRequestMapper.toModel(requestDto));
        return masterResponseMapper.toDto(master);
    }

    @PutMapping
    @ApiOperation(value = "Update info about master in DB",
            notes = "Return master from DB after update")
    public MasterResponseDto updateMaster(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Master id") Long id,
            @RequestBody MasterRequestDto requestDto) {
        Master master = masterRequestMapper.toModel(requestDto);
        master.setId(id);
        return masterResponseMapper.toDto(masterService.update(master));
    }

    @GetMapping("/jobs")
    @ApiOperation(value = "Get list operation from DB",
            notes = "Return list of operation fro current master")
    public List<OperationResponseDto> getAllJobs(@RequestParam(name = "id")
                                 @ApiParam(name = "id", value = "Master id") Long id) {
        Master master = masterService.get(id).get();
        return master.getOperations().stream()
                .map(o -> operationResponseMapper.toDto(o))
                .collect(Collectors.toList());
    }

    @GetMapping("/salary")
    @ApiOperation(value = "Get salary", notes = "Return salary for current master from DB")
    public BigDecimal getMasterSalary(@RequestParam(name = "id")
                                      @ApiParam(name = "id", value = "Master id") Long id) {
        return masterService.calculateSalary(id);
    }
}
