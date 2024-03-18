package com.turkcell.rentacar.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandDto {
    private int id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
