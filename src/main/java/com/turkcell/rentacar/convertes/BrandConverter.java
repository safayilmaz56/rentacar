package com.turkcell.rentacar.convertes;

import com.turkcell.rentacar.dtos.BrandDto;
import com.turkcell.rentacar.entities.concretes.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    public BrandDto toDto(Brand brand){
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        return brandDto;
    }

    public Brand toEntity(BrandDto brandDto){
        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setName(brandDto.getName());
        brand.setCreatedDate(brandDto.getCreatedDate());
        brand.setUpdatedDate(brandDto.getUpdatedDate());
        return brand;
    }
}
