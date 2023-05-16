package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.pyload.ReqLogin;
import it.revo.first_spring_boot_backend2.pyload.ReqRegister;
import it.revo.first_spring_boot_backend2.pyload.ResLogin;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.AuthService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping
    public String getAuth() {
        return "auth";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/register/code")
    public String code() {
        return "code";
    }

    @GetMapping("/user")
    public String admin() {
        return "user";
    }

    @SneakyThrows
    @PostMapping("/login")
    @ResponseBody
    public ResLogin login(@RequestBody ReqLogin reqLogin) {
        return authService.login(reqLogin);
    }


    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody ReqRegister reqRegister) {
        return authService.register(reqRegister);
    }

    @PostMapping("/register/code")
    @ResponseBody
    public Result code(@RequestBody ReqRegister reqRegister) {
        return authService.saveUser(reqRegister);
    }
}
