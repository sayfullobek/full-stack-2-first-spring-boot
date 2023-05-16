package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    boolean existsRegionByNameEqualsIgnoreCase(String name);
}
