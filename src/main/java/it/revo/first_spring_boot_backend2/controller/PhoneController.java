package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.logic.LogicAbs;
import it.revo.first_spring_boot_backend2.pyload.ReqPhone;
import it.revo.first_spring_boot_backend2.pyload.ResPhone;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phone")
public class PhoneController extends LogicAbs {
    @Autowired
    PhoneService phoneService;

    @GetMapping
    public String getPhone(){
        return "phone";
    }
    @Override
    @GetMapping("/list")
    @ResponseBody
    public List<ResPhone> getPhoneList() {
      return phoneService.getPhoneList();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseBody
    public ResPhone getOnePhone(Integer id) {
      return phoneService.getOnePhone(id);
    }

    @Override
    @PostMapping
    @ResponseBody
    public Result addPhone(@RequestBody ReqPhone reqPhone) {
      return phoneService.addPhone(reqPhone);
    }



    @Override
    @PutMapping("/{id}")
    @ResponseBody
    public Result editPhone(@PathVariable Integer id, @RequestBody ReqPhone reqPhone) {
        return phoneService.editPhone(id,reqPhone);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deletePhone(@PathVariable Integer id) {
        return phoneService.deletePhone(id);

    }
}

