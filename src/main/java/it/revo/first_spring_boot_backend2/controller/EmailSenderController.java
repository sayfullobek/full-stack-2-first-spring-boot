package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.EmailSenderService;
import it.revo.first_spring_boot_backend2.pyload.ReqEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class EmailSenderController {
    @Autowired
    EmailSenderService senderServicel;

    @PostMapping
    @ResponseBody
    public Result emailSender(@RequestBody ReqEmailSender reqEmailSender) {
        return senderServicel.send(reqEmailSender);
    }
}
