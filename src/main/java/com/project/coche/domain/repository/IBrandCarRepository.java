package com.project.coche.domain.repository;

import com.project.coche.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una una mcarca dad su id
     * @param id Id de marca coche
     * @return OPtional del marca coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    BrandCarPojo saveBrandCar(BrandCarPojo newBrandCar);
    void deleteBrandCar(Integer idBrandCar);
}
