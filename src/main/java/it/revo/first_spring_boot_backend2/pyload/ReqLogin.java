package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReqLogin {
    private String phoneNumber;
    private String password;
}
