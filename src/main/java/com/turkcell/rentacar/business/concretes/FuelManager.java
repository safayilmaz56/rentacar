package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    @Override
    public void add(Fuel fuel) {
        this.fuelRepository.save(fuel);
    }

    @Override
    public Fuel getById(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            return existsFuel.get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public List<Fuel> getAll() {
        return this.fuelRepository.findAll();
    }

    @Override
    @Transactional
    public void update(int id, Fuel fuel) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            existsFuel.get().setFuelType(fuel.getFuelType());
            existsFuel.get().setUpdatedDate(fuel.getUpdatedDate());

            this.fuelRepository.save(existsFuel.get());
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            this.fuelRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }

    }

    private boolean isExists(int id){
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
}
