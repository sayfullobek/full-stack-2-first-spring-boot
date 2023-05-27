package it.revo.first_spring_boot_backend2.entity;

import it.revo.first_spring_boot_backend2.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Products extends AbsNameEntity {
    @Column(nullable = false)
    private double price;

    @Column(nullable = false, unique = true, length = 9999999)
    private String imgUrl; //qiymati -> 256
    @ManyToOne
    private Category category;

}
