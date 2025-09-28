package com.turkcell.ecommerce_cqrs.application.product.query;

import com.turkcell.ecommerce_cqrs.application.product.dto.ProductResponse;
import com.turkcell.ecommerce_cqrs.core.cqrs.QueryHandler;

import java.util.List;

public class ListProductsQueryHandler implements QueryHandler<ListProductsQuery, List<ProductResponse>> {
    @Override
    public List<ProductResponse> handle(ListProductsQuery query) {
        return List.of();
    }
}
// Product için yapılan tüm işlemleri domain-persistence-application (içi boş) için oluşturunuz.