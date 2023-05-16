package it.revo.first_spring_boot_backend2.repository;

import it.revo.first_spring_boot_backend2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Integer> {
    boolean existsUserByPhoneNumber(String phoneNumber);

    User findUserByPhoneNumber(String phoneNumber);

    boolean existsUserByEmail(String email);
}
