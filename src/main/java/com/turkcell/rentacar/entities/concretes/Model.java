package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.dtos.BrandDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "dailyPrice")
    private BigDecimal dailyPrice;

    @ManyToOne
    @JoinColumn(name = "markaId")
    private Brand brand;
}
