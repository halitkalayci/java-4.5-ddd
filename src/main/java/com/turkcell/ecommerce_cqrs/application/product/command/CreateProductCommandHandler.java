package com.turkcell.ecommerce_cqrs.application.product.command;

import com.turkcell.ecommerce_cqrs.application.product.dto.CreatedProductResponse;
import com.turkcell.ecommerce_cqrs.application.product.mapper.CreateProductMapper;
import com.turkcell.ecommerce_cqrs.core.cqrs.CommandHandler;
import com.turkcell.ecommerce_cqrs.domain.product.model.Product;
import com.turkcell.ecommerce_cqrs.domain.product.policy.ProductNameUniquePolicy;
import com.turkcell.ecommerce_cqrs.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, CreatedProductResponse>
{
    private final ProductRepository productRepository;
    private final CreateProductMapper createProductMapper;
    private final ProductNameUniquePolicy productNameUniquePolicy;

    public CreateProductCommandHandler(ProductRepository productRepository, CreateProductMapper createProductMapper, ProductNameUniquePolicy productNameUniquePolicy) {
        this.productRepository = productRepository;
        this.createProductMapper = createProductMapper;
        this.productNameUniquePolicy = productNameUniquePolicy;
    }

    @Override
    public CreatedProductResponse handle(CreateProductCommand command) {
        if(!productNameUniquePolicy.isUnique(command.name()))
            throw new RuntimeException("Product name is not unique");

        Product product = createProductMapper.toDomain(command);
        product = productRepository.save(product);
        return createProductMapper.toResponse(product);
    }
}
