package com.turkcell.ecommerce_cqrs.infrastructure.product;

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

    public ProductRepositoryAdapter(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        // Product-JpaProductEntity mapping.
        // Veritabanına kaydet
        // Kaydedilen yapıyı Producta geri maple return.
        return null;
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
