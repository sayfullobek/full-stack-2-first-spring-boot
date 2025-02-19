package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResPhone {
    private Integer tr;
    private Integer id;
    private String name;
    private String model;
    private Integer memory;
    private Integer ram;
    private double price;
}
