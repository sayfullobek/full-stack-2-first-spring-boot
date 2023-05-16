package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqRegister {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private String code;
}
