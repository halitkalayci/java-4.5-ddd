package com.turkcell.ecommerce_cqrs.domain.product.repository;

import com.turkcell.ecommerce_cqrs.domain.product.model.Product;
import com.turkcell.ecommerce_cqrs.domain.product.model.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository
{
    Product save(Product product);
    Optional<Product> findById(ProductId productId);
    List<Product> findAll();
    List<Product> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(ProductId productId);
}
