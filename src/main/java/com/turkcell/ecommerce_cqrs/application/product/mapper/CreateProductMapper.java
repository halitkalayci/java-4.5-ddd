package com.turkcell.ecommerce_cqrs.application.product.mapper;

import com.turkcell.ecommerce_cqrs.application.product.command.CreateProductCommand;
import com.turkcell.ecommerce_cqrs.application.product.dto.CreatedProductResponse;
import com.turkcell.ecommerce_cqrs.domain.product.model.Money;
import com.turkcell.ecommerce_cqrs.domain.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class CreateProductMapper {
    public Product toDomain(CreateProductCommand command)
    {
        return Product.create(
                command.name(),
                command.description(),
                new Money(command.price(), command.currency()),
                command.stock()
        );
    }

    public CreatedProductResponse toResponse(Product product)
    {
        return new CreatedProductResponse(
                product.id().value(),
                product.name(),
                product.description()
        );
    }
}
