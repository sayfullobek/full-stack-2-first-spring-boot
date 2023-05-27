package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResCategory {
    private Integer tr;
    private UUID id;
    private String name;
}
