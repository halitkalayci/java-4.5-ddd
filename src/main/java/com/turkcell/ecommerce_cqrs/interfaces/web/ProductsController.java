package com.turkcell.ecommerce_cqrs.interfaces.web;

import com.turkcell.ecommerce_cqrs.application.product.command.CreateProductCommand;
import com.turkcell.ecommerce_cqrs.application.product.dto.CreatedProductResponse;
import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.application.product.query.ListProductsQuery;
import com.turkcell.ecommerce_cqrs.core.cqrs.CommandHandler;
import com.turkcell.ecommerce_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductsController {
    private final QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler;
    private final CommandHandler<CreateProductCommand, CreatedProductResponse> createProductCommandHandler;

    public ProductsController(QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler, CommandHandler<CreateProductCommand, CreatedProductResponse> createProductCommandHandler) {
        this.listProductsQueryHandler = listProductsQueryHandler;
        this.createProductCommandHandler = createProductCommandHandler;
    }

    @GetMapping
    public List<ProductResponse> getProducts(@Valid ListProductsQuery query) {
        return listProductsQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse createProduct(@Valid @RequestBody CreateProductCommand command) {
        return createProductCommandHandler.handle(command);
    }
}
