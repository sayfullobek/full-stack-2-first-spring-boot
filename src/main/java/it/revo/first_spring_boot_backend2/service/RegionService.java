package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Country;
import it.revo.first_spring_boot_backend2.entity.Region;
import it.revo.first_spring_boot_backend2.pyload.ReqRegion;
import it.revo.first_spring_boot_backend2.pyload.ResRegion;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.repository.CountryRepository;
import it.revo.first_spring_boot_backend2.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    public List<ResRegion> getRegion() {
        List<Region> regions = regionRepository.findAll();
        List<ResRegion> resRegionList = new ArrayList<>();
        int tr = 1;
        for (Region region : regions) {
            resRegionList.add(
                    ResRegion.builder()
                            .tr(tr)
                            .id(region.getId())
                            .name(region.getName())
                            .countryName(region.getCountry().getName())
                            .build()
            );
            tr++;
        }
        return resRegionList;
    }

    public Result addRegion(ReqRegion reqRegion) {
        Optional<Country> byId = countryRepository.findById(reqRegion.getCountryId());
        if (byId.isPresent()) {
            boolean existName = regionRepository.existsRegionByNameEqualsIgnoreCase(reqRegion.getName());
            if (!existName) {
                Country country = byId.get();
                Region region = new Region();
                region.setName(reqRegion.getName());
                region.setCountry(country);
                regionRepository.save(region);
                return new Result("muvaffaqiyatli saqlandi", true);
            }
            return new Result("bunday viloyat avvaldan mavjud", false);
        }
        return new Result("bunday davlat mavjud emas", false);
    }

    public Result editRegion(Integer id, ReqRegion reqRegion) {
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isPresent()) {
            boolean exist = regionRepository.existsRegionByNameEqualsIgnoreCaseAndIdNot(reqRegion.getName(), id);
            if (!exist) {
                Optional<Country> byId1 = countryRepository.findById(reqRegion.getCountryId());
                if (byId1.isPresent()) {
                    Region region = byId.get();
                    Country country = byId1.get();
                    region.setName(reqRegion.getName());
                    region.setCountry(country);
                    regionRepository.save(region);
                    return new Result("Taxrirlandi", true);
                }
                return new Result("xatolik", false);
            }
            return new Result("xatolik", false);
        }
        return new Result("xatolik", false);
    }

    public Result deleteRegion(Integer id) {
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isPresent()) {
            Region region = byId.get();
            regionRepository.delete(region);
            return new Result("o'chirildi", true);
        }
        return new Result("this is country not found", false);
    }
}
