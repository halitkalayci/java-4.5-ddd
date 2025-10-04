package com.turkcell.ecommerce_cqrs.infrastructure.product.policy;

import com.turkcell.ecommerce_cqrs.domain.product.policy.ProductNameUniquePolicy;
import com.turkcell.ecommerce_cqrs.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaProductNameUniqueChecker implements ProductNameUniquePolicy {
    private final ProductRepository productRepository;

    public JpaProductNameUniqueChecker(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isUnique(String name) {
        return !productRepository.existsByNameIgnoreCase(name);
    }
}
