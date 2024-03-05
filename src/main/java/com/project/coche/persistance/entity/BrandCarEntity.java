package com.project.coche.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * entidad de marca_coche
 */
@Getter
@Setter
@Entity
@Table(name="marca_coche")
public class BrandCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String description;

}
