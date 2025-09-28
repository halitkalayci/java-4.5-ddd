package com.turkcell.ecommerce_cqrs.application.product.command;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name, String description, BigDecimal price, String currency, Integer stock
) { }
