package it.revo.first_spring_boot_backend2.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class District {
    @Id
    private UUID uuid;
}
