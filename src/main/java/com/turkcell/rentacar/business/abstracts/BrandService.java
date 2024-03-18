package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.BrandFuel;

import java.util.List;

public interface BrandService {
    void add(Brand brand);
    Brand getById(int id);
    List<Brand> getAll();
    void update(int id,Brand brand);
    void delete(int id);
    Brand getByName(String name);
}
