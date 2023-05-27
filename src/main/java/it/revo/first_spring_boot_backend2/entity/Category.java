package it.revo.first_spring_boot_backend2.entity;

import it.revo.first_spring_boot_backend2.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends AbsEntity {
    private String name;
}
