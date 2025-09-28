package com.turkcell.ecommerce_cqrs.persistence.product;

import com.turkcell.ecommerce_cqrs.domain.product.model.Product;
import com.turkcell.ecommerce_cqrs.domain.product.model.ProductId;
import com.turkcell.ecommerce_cqrs.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository
{
    private final SpringDataProductRepository repository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryAdapter(SpringDataProductRepository repository, ProductEntityMapper productEntityMapper) {
        this.repository = repository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product save(Product product) {
        JpaProductEntity entity = productEntityMapper.toEntity(product);
        entity = this.repository.save(entity);
        return productEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void delete(ProductId productId) {

    }
}
