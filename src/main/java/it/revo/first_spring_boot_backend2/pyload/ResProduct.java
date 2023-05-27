package it.revo.first_spring_boot_backend2.pyload;

import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResProduct {
    private Integer tr;
    private Integer id;
    private String name;
    private double price;
    private String img;
    private String CategoryName;
}
