package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.convertes.BrandConverter;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.dtos.BrandDto;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private BrandService brandService;

    @Override
    public void add(Model model) {
        this.modelRepository.save(model);

    }

    @Override
    public Model getById(int id) {
        if (isExists(id)){
            return this.modelRepository.findById(id).get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public List<Model> getAll() {
        return this.modelRepository.findAll();
    }

    @Override
    @Transactional
    public void update(int id, Model model) {
        if (isExists(id)){
            Model existModel = this.modelRepository.findById(id).get();
            existModel.setName(model.getName());
            existModel.setDailyPrice(model.getDailyPrice());
            existModel.setUpdatedDate(model.getUpdatedDate());

            this.modelRepository.save(existModel);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        if (isExists(id)){
            Model existModel = this.modelRepository.findById(id).get();
            this.modelRepository.delete(existModel);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    private boolean isExists(int id){
        Optional<Model> existsModel = this.modelRepository.findById(id);
        if (existsModel.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
}
