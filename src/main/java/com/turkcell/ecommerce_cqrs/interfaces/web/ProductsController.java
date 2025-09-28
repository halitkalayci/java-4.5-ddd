package com.turkcell.ecommerce_cqrs.interfaces.web;

import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.application.product.query.ListProductsQuery;
import com.turkcell.ecommerce_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductsController {
    private final QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler;

    public ProductsController(QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler) {
        this.listProductsQueryHandler = listProductsQueryHandler;
    }

    @GetMapping
    public List<ProductResponse> getProducts(@Valid ListProductsQuery query) {
        return listProductsQueryHandler.handle(
                query
        );
    }
}
