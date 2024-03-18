package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fuels")
public class Fuel extends BaseEntity {

    @Column(name = "fuelType")
    private String fuelType;

    @OneToMany(mappedBy = "fuel")
    private List<BrandFuel> brandFuelList;
}
