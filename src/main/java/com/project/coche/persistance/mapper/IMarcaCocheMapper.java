package com.project.coche.persistance.mapper;

import com.project.coche.domain.pojo.MarcaCochePojo;
import com.project.coche.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaEntity);
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);

    List<MarcaCochePojo> toMarcasCochePojo(List<MarcaCocheEntity> marcasCocheEntity);
}
