package it.revo.first_spring_boot_backend2.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqEmailSender {
    private String toEmail;
    private String subject;
    private String body;
}
