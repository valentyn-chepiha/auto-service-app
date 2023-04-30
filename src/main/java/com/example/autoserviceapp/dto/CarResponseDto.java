package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarResponseDto {
    @ApiModelProperty(notes = "Car id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "Brand name", example = "Opel")
    private String brand;
    @ApiModelProperty(notes = "Model name", example = "Vectra")
    private String model;
    @ApiModelProperty(notes = "Year of product", example = "1995")
    private int year;
    @ApiModelProperty(notes = "Car number", example = "CB5678TK")
    private String carNumber;
    @ApiModelProperty(notes = "Owner id", example = "1")
    private Long ownerId;
}
