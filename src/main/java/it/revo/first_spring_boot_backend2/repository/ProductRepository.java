package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Products,Integer>{
    boolean existsProductsByNameEqualsIgnoreCase(String name);
}
