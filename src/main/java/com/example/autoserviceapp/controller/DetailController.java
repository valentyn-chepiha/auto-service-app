package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.DetailRequestDto;
import com.example.autoserviceapp.dto.DetailResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.service.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detail")
@RequiredArgsConstructor
public class DetailController {
    private RequestMapper<Detail, DetailRequestDto> detailRequestMapper;
    private ResponseMapper<Detail, DetailResponseDto> detailResponseMapper;
    private BaseService<Detail, Long> detailService;

    @PostMapping
    @ApiOperation(value = "Add new detail to DB", notes = "Return new detail with id")
    public DetailResponseDto createDetail(@RequestBody DetailRequestDto detailRequestDto) {
        Detail detail = detailRequestMapper.toModel(detailRequestDto);
        return detailResponseMapper.toDto(detailService.add(detail));
    }

    @PutMapping
    @ApiOperation(value = "Update info about detail in DB",
            notes = "Return detail from DB after update")
    public DetailResponseDto updateDetail(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Detail id") Long id,
            @RequestBody DetailRequestDto detailRequestDto) {
        Detail detail = detailRequestMapper.toModel(detailRequestDto);
        detail.setId(id);
        return detailResponseMapper.toDto(detailService.update(detail));
    }
}
