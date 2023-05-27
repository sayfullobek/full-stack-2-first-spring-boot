package it.revo.first_spring_boot_backend2.pyload;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqProduct {
    private String name;
    private double price;
    private String ImgUrl;
    private UUID CategoryId;

}
