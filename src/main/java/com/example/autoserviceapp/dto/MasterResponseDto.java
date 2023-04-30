package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class MasterResponseDto {
    @ApiModelProperty(notes = "Master id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "Master PIB", example = "Kovalenko Mykola Petrovych")
    private String pib;
    @ApiModelProperty(notes = "List of operation id", example = "[1, 3, 5, 4]")
    private List<Long> operationIds;
}
