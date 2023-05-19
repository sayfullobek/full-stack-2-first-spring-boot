package it.revo.first_spring_boot_backend2.pyload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResRegion {
    private Integer tr;
    private Integer id;
    private String name;
    private String countryName;
}
