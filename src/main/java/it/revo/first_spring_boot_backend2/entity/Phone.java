package it.revo.first_spring_boot_backend2.entity;

import it.revo.first_spring_boot_backend2.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Phone extends AbsNameEntity {
    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer memory;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private double price;
}
