package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.entity.Country;
import it.revo.first_spring_boot_backend2.pyload.ReqCountry;
import it.revo.first_spring_boot_backend2.pyload.ResCountry;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
    @RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public String getCountry() {
        return "country";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ResCountry> getCountryList() {
        return countryService.getCountries();
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addCountry(@RequestBody ReqCountry reqCountry) {
        return countryService.addCountry(reqCountry);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteCountry(@PathVariable Integer id) {
        return countryService.deleteCountry(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Result editCountry(@PathVariable Integer id, @RequestBody ReqCountry reqCountry) {
        return countryService.editCountry(id, reqCountry);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Country getOneCountry(@PathVariable Integer id) {
        return countryService.getOne(id);
    }

    //GetMapping -> malumotni chiqarish uchun
    //postmapping -> qoshish uchun
    //putmaping -> taxrirlash uchun
    //deleteMapping -> ochirish uchun
}
