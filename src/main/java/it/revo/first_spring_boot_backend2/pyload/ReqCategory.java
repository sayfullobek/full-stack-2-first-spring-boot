package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCategory {
    private UUID id;
    private String name;
}
