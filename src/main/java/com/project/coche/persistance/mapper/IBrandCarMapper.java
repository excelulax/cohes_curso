package com.project.coche.persistance.mapper;

import com.project.coche.domain.pojo.BrandCarPojo;
import com.project.coche.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandCarMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarPojo toBrandCarPojo(BrandCarEntity brandEntity);
    @InheritInverseConfiguration
    BrandCarEntity toBrandCarEntity(BrandCarPojo brandCarPojo);

    List<BrandCarPojo> toBrandsCarPojo(List<BrandCarEntity> brandsCarEntity);
}
