package com.turkcell.ecommerce_cqrs.application.product.query;

import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListProductsQuery(
        @Min(0) Integer pageIndex,
        @Min(1)  Integer pageSize
) implements Query<List<ProductResponse>> { }

