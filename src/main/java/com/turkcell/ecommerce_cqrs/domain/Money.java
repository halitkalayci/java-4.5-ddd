package com.turkcell.ecommerce_cqrs.domain;

// Classın immutable (değiştirilemez) hali

import java.math.BigDecimal;
import java.util.Objects;

// Value Object
public record Money(BigDecimal amount, String currency) {
    public Money {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);

        if (amount.signum() < 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (currency.isBlank())
            throw new IllegalArgumentException("Currency cannot be blank");
    }
}
