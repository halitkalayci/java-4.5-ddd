package com.turkcell.ecommerce_cqrs.application.product.query;

import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.core.cqrs.Query;

import java.util.List;

public record ListProductsQuery(
        Integer pageIndex, Integer pageSize
) implements Query<List<ProductResponse>> { }

