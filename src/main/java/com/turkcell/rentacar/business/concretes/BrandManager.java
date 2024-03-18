package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    @Override
    public void add(Brand brand) {
        this.brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {
        if (isExists(id)){
            return this.brandRepository.findById(id).get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }

    }

    @Override
    public List<Brand> getAll() {
        return this.brandRepository.findAll();
    }

    @Override
    @Transactional
    public void update(int id, Brand brand) {
        if (isExists(id)){
            Brand existsBrand = this.brandRepository.findById(id).get();
            existsBrand.setName(brand.getName());
            existsBrand.setUpdatedDate(brand.getUpdatedDate());

            this.brandRepository.save(existsBrand);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        if (isExists(id)){
            Brand existsBrand = this.brandRepository.findById(id).get();
            this.brandRepository.delete(existsBrand);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public Brand getByName(String name) {
        Brand brand = this.brandRepository.getByName(name);
        return brand;
    }

    private boolean isExists(int id){
        Optional<Brand> existsBrand = this.brandRepository.findById(id);
        if (existsBrand.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
}
