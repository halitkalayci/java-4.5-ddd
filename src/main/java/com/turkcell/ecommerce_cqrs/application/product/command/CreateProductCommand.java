package com.turkcell.ecommerce_cqrs.application.product.command;

import com.turkcell.ecommerce_cqrs.application.product.dto.CreatedProductResponse;
import com.turkcell.ecommerce_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProductCommand(
        @NotBlank @Size(min=3,max = 255) String name,
        @NotBlank @Size(min=3,max = 255) String description,
        @Positive BigDecimal price,
        @NotBlank @Size(min=2,max = 255) String currency,
        @Min(0) Integer stock
) implements Command<CreatedProductResponse> { }
