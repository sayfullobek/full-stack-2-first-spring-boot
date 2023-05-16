package it.revo.first_spring_boot_backend2.pyload;

import it.revo.first_spring_boot_backend2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResLogin {
    private Result result;
    private User user;
}
