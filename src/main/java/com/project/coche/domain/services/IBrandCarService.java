package com.project.coche.domain.services;

import com.project.coche.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {
    List<BrandCarPojo> getAll();
    Optional<BrandCarPojo> getBrandCar(Integer id);
    BrandCarPojo saveBrandCar(BrandCarPojo newBrandCar);
    Optional<BrandCarPojo> updateBrandCar(BrandCarPojo updateBrandCar);
    boolean deleteBrandCar(Integer idBrandCar);
}
