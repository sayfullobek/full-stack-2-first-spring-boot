package it.revo.first_spring_boot_backend2.entity;

import it.revo.first_spring_boot_backend2.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Region extends AbsNameEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;
}
