package com.turkcell.ecommerce_cqrs.application.product.query;

import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.application.product.mapper.ProductResponseMapper;
import com.turkcell.ecommerce_cqrs.core.cqrs.QueryHandler;
import com.turkcell.ecommerce_cqrs.domain.product.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
public class ListProductsQueryHandler implements QueryHandler<ListProductsQuery, List<ProductResponse>> {
    private final ProductRepository productRepository;
    private final ProductResponseMapper productResponseMapper;

    public ListProductsQueryHandler(ProductRepository productRepository, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public List<ProductResponse> handle(ListProductsQuery query) {
        return productRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(productResponseMapper::toResponse)
                .toList();
    }
}

