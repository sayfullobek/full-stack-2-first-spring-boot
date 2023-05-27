package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
