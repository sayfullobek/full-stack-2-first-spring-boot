package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Role;
import it.revo.first_spring_boot_backend2.entity.User;
import it.revo.first_spring_boot_backend2.pyload.*;
import it.revo.first_spring_boot_backend2.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Random;

@Service
public class AuthService extends HttpServlet {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    EmailSenderService emailService;
    String kod = "";

    public ResLogin login(ReqLogin reqLogin) throws IOException {
        if (authRepository.existsUserByPhoneNumber(reqLogin.getPhoneNumber())) {
            User user = authRepository.findUserByPhoneNumber(reqLogin.getPhoneNumber());
            if (user.getPassword().equals(reqLogin.getPassword())) {
//                HttpServletResponse resp = null;
//                PrintWriter writer = resp.getWriter();
//                writer.write(
//                        "<script>\n" +
//                                "    localStorage.setItem(\"phoneNumber\", \"\")\n" +
//                                "    localStorage.setItem(\"password\", \"\")\n" +
//                                "</script>"
//                );
                return new ResLogin(new Result("hush kelibsiz", true), user);
            }
            return new ResLogin(new Result("parol xato qayta urinib ko'ring", false), null);
        }
        return new ResLogin(new Result("bunday tel raqam mavjud emas", false), null);
    }

    public Result register(ReqRegister reqRegister) {
        if (!authRepository.existsUserByEmail(reqRegister.getEmail())) {
            if (!authRepository.existsUserByPhoneNumber(reqRegister.getPhoneNumber())) {
                kod = generatedRandom();
                ReqEmailSender reqEmailSender = new ReqEmailSender(
                        reqRegister.getEmail(),
                        "parol servicel",
                        "sizning kodingiz " + kod
                );
                emailService.send(reqEmailSender);
                return new Result("sizning emailingizga kod yuborik", true);
            }
            return new Result("bunday tel raqam avvaldan mavjud", false);
        }
        return new Result("bunday email avvaldan mavjud", false);
    }

    public Result saveUser(ReqRegister reqRegister) {
        if (reqRegister.getCode().equals(kod)) {
            User build = User.builder()
                    .surname(reqRegister.getSurname())
                    .email(reqRegister.getEmail())
                    .phoneNumber(reqRegister.getPhoneNumber())
                    .password(reqRegister.getPassword())
                    .role(Role.USER)
                    .build();
            build.setName(reqRegister.getName());
            authRepository.save(build);
            return new Result("mallades", true);
        }
        return new Result("quri", false);
    }

    public String generatedRandom() {
        String alphabet = "10923874566574382901";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
