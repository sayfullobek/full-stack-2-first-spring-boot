package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Country;
import it.revo.first_spring_boot_backend2.pyload.ReqCountry;
import it.revo.first_spring_boot_backend2.pyload.ReqEmailSender;
import it.revo.first_spring_boot_backend2.pyload.ResCountry;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;


    public List<ResCountry> getCountries() {
        List<Country> all = countryRepository.findAll();
        List<ResCountry> resCountries = new ArrayList<>();
        int tr = 1;
        for (Country country : all) {
            ResCountry resCountry = new ResCountry(
                    tr, country.getId(), country.getName()
            );
            resCountries.add(resCountry);
            tr++;
        }
        return resCountries;
    }

    public Result addCountry(ReqCountry reqCountry) {
        boolean exist = countryRepository.existsCountryByNameEqualsIgnoreCase(reqCountry.getName());
        if (!exist) {
            Country country = new Country();
            country.setName(reqCountry.getName());
            countryRepository.save(country);
            return new Result("muvaffaqiyatli yaratildi", true);
        }
        return new Result("bunday davlat avvaldan mavjud oka", false);
    }

    public Result deleteCountry(Integer id) {
        Optional<Country> byId = countryRepository.findById(id);
        if (byId.isPresent()) {
            Country country = byId.get();
            countryRepository.delete(country);
            return new Result("o'chirildi", true);
        }        return new Result("this is country not found", false);
    }

    public Result editCountry(Integer id, ReqCountry reqCountry) {
        Optional<Country> byId = countryRepository.findById(id);
        if (byId.isPresent()) {
            boolean exist = countryRepository.existsCountryByNameEqualsIgnoreCaseAndIdNot(reqCountry.getName(), id);
            if (!exist) {
                Country country = byId.get();
                country.setName(reqCountry.getName());
                countryRepository.save(country);
                return new Result("taxrirlandi", true);
            }
            return new Result("bunday country avvaldan mavjud", false);
        }
        return new Result("bunday country yo'q", false);
    }

    public Country getOne(Integer id) {
        Optional<Country> byId = countryRepository.findById(id);
        return byId.orElse(null);
    }
}
