package com.turkcell.ecommerce_cqrs.infrastructure.product;

import com.turkcell.ecommerce_cqrs.domain.product.model.Money;
import com.turkcell.ecommerce_cqrs.domain.product.model.Product;
import com.turkcell.ecommerce_cqrs.domain.product.model.ProductId;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper
{
    public JpaProductEntity toEntity(Product product)
    {
        JpaProductEntity productEntity = new JpaProductEntity();
        productEntity.setId(product.id().value());
        productEntity.setName(product.name());
        productEntity.setDescription(product.description());
        productEntity.setAmount(product.money().amount());
        productEntity.setCurrency(product.money().currency());
        productEntity.setStock(product.stock());
        return productEntity;
    }

    public Product toDomain(JpaProductEntity entity)
    {
        return Product.rehydrate(
                new ProductId(entity.id()),
                entity.name(),
                entity.description(),
                new Money(entity.amount(), entity.currency()),
                entity.stock()
        );
    }
}
