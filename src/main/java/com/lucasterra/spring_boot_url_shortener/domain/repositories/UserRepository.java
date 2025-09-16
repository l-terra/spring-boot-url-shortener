package com.lucasterra.spring_boot_url_shortener.domain.repositories;

import com.lucasterra.spring_boot_url_shortener.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
