package com.turkcell.ecommerce_cqrs.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataProductRepository extends JpaRepository<JpaProductEntity, UUID>
{
}
