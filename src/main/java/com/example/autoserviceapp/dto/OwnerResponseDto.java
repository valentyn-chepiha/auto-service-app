package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class OwnerResponseDto {
    @ApiModelProperty(notes = "Owner id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "Owner name", example = "Redko Oleh")
    private String name;
    @ApiModelProperty(notes = "List car id", example = "[12, 15, 23, 45]")
    private List<Long> carIds;
    @ApiModelProperty(notes = "List order id", example = "[1, 2 , 3, 5]")
    private List<Long> orderIds;
}
