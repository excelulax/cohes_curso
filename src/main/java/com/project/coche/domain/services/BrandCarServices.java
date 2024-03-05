package com.project.coche.domain.services;

import com.project.coche.domain.pojo.BrandCarPojo;
import com.project.coche.domain.repository.IBrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BrandCarServices implements  IBrandCarService{
    private final IBrandCarRepository iBrandCarRepository;

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarPojo saveBrandCar(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.saveBrandCar(newBrandCar);
    }

    @Override
    public Optional<BrandCarPojo> updateBrandCar(BrandCarPojo updateBrandCar) {
        if(iBrandCarRepository.getBrandCar(updateBrandCar.getId()).isEmpty()){
            return Optional.empty();
        }
        return  Optional.of(iBrandCarRepository.saveBrandCar(updateBrandCar));
    }

    @Override
    public boolean deleteBrandCar(Integer idBrandCar) {
        try{
            iBrandCarRepository.deleteBrandCar(idBrandCar);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
