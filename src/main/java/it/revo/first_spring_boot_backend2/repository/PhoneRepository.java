package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone , Integer> {
}
