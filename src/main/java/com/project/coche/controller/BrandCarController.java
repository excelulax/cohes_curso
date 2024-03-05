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
public class BrandCarController {
    private final IBrandCarService iBrandCarService;

    @GetMapping
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        List<BrandCarPojo> lista = iBrandCarService.getAll();
        return ResponseEntity.ok(lista);
        //return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll()); ALTENATIVA
        //return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); ALTERNATIVA
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping
    public ResponseEntity<BrandCarPojo> saveBrandCar(@RequestBody BrandCarPojo newBrandCarPojo){
        return ResponseEntity.of(iBrandCarService.updateBrandCar(newBrandCarPojo));
    }

    @PutMapping
    public ResponseEntity<BrandCarPojo> updateBrandCar(@RequestBody BrandCarPojo newBrandCarPojo){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.saveBrandCar(newBrandCarPojo));
        }catch (Exception e){
            //corregir
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteBrandCar(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.deleteBrandCar(id)? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }
}
