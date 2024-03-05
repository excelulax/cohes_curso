package com.project.coche.controller;

import com.project.coche.domain.pojo.BrandCarPojo;
import com.project.coche.domain.services.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas_coches")
public class BranCarController {
    private final IBrandCarService iBrandCarService;

    @GetMapping
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        return ResponseEntity.ok(iBrandCarService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll()); ALTENATIVA
        //return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); ALTERNATIVA
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping
    public ResponseEntity<BrandCarPojo> SaveBrandCar(@RequestBody BrandCarPojo newBrandCarPojo){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iBrandCarService.saveBrandCar(newBrandCarPojo));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
