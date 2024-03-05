package com.project.coche.persistance.repository;

import com.project.coche.domain.pojo.BrandCarPojo;
import com.project.coche.domain.repository.IBrandCarRepository;
import com.project.coche.persistance.entity.BrandCarEntity;
import com.project.coche.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;
    private final IBrandCarMapper iBrandCarMapper;

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toBrandsCarPojo(iBrandCarCrudRepository.findAll());
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id).map(iBrandCarMapper::toBrandCarPojo);
    }

    @Override
    public BrandCarPojo saveBrandCar(BrandCarPojo newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toBrandCarEntity(newBrandCar);
        return iBrandCarMapper.toBrandCarPojo(iBrandCarCrudRepository.save(brandCarEntity));

    }

    @Override
    public void deleteBrandCar(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
