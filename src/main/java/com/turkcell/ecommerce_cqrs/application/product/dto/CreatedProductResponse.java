package com.turkcell.ecommerce_cqrs.application.product.dto;

import java.util.UUID;

public record CreatedProductResponse(UUID id, String name, String description) { }
