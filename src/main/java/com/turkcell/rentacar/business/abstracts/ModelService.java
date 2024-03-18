package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    void add(Model model);
    Model getById(int id);
    List<Model> getAll();
    void update(int id,Model model);
    void delete(int id);
}
