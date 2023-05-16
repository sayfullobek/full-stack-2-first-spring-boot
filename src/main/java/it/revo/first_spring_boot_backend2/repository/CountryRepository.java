package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    boolean existsCountryByNameEqualsIgnoreCase(String name);

    boolean existsCountryByNameEqualsIgnoreCaseAndIdNot(String name, Integer id);
}
