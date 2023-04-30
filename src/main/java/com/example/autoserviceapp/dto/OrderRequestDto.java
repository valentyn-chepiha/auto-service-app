package com.example.autoserviceapp.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    @ApiModelProperty(notes = "Car id", example = "1")
    private Long carId;
    @ApiModelProperty(notes = "Description of order", example = "Noise in the gearbox")
    private String description;
    @ApiModelProperty(notes = "Date start order", example = "01.07.2023")
    private LocalDate dateStart;
    @ApiModelProperty(notes = "List operation id", example = "[1, 2, 3, 4]")
    private List<Long> operationIds;
    @ApiModelProperty(notes = "Detail id", example = "1")
    private List<Long> detailIds;
    @ApiModelProperty(notes = "Status name", example = "Accepted, Processing, Done, Fail, Paid")
    private String statusName;
    @ApiModelProperty(notes = "The total amount of the order", example = "1500")
    private BigDecimal total;
    @ApiModelProperty(notes = "Date finish order", example = "05.07.2023")
    private LocalDate dateEnd;
    @ApiModelProperty(notes = "Owner id", example = "1")
    private Long ownerId;
}
