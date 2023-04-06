package com.ecommerce.safeWay.repository;

import com.ecommerce.safeWay.repository.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Usuario, Long> {
}
