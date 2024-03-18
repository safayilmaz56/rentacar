package com.turkcell.rentacar.api.controllers.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.convertes.BrandConverter;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    private BrandConverter brandConverter;

    @PostMapping("/add")
    public void add(@RequestBody Model model){
        this.modelService.add(model);
    }
    @GetMapping("/getById/{id}")
    public Model getById(@PathVariable int id){
        return this.modelService.getById(id);
    }
    @GetMapping("/getAll")
    public List<Model> getAll(){
        return this.modelService.getAll();
    }
    @PostMapping("/update/{id}")
    public void update(@PathVariable int id,@RequestBody Model model){
        this.modelService.update(id, model);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }
}
