package com.turkcell.rentacar.api.controllers.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.convertes.BrandConverter;
import com.turkcell.rentacar.dtos.BrandDto;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {  //isimlendirmede s takısı alır

    private final BrandService brandService;  //IoC
    private final BrandConverter brandConverter;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED) //yanıtı belirtir.
    public void add(@RequestBody BrandDto brandDto){
        Brand brand = this.brandConverter.toEntity(brandDto);
        this.brandService.add(brand);
    }

    @GetMapping("/getById/{id}")
    public Brand getById(@PathVariable int id){
        return this.brandService.getById(id);
    }
    @GetMapping("/getAll")
    public List<Brand> getAll(){
        return this.brandService.getAll();
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable int id,@RequestBody BrandDto brandDto){
        Brand brand = this.brandConverter.toEntity(brandDto);
        this.brandService.update(id,brand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(int id){
        this.brandService.delete(id);
    }
}
