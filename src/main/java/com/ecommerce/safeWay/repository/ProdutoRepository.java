package com.ecommerce.safeWay.repository;

import com.ecommerce.safeWay.repository.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
