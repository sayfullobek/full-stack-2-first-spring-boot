package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.pyload.ReqEmailSender;
import it.revo.first_spring_boot_backend2.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    JavaMailSender javaMailSender;

    public Result send(ReqEmailSender reqEmailSender) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dilbekk3@gmail.com");
        message.setTo(reqEmailSender.getToEmail());
        message.setText(reqEmailSender.getBody());
        message.setSubject(reqEmailSender.getSubject());
        javaMailSender.send(message);
        return new Result("oka sms ketdi", true);
    }
}
