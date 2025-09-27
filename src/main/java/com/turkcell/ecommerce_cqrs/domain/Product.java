package com.turkcell.ecommerce_cqrs.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

// Domain Object
// Saf Java.

// Aggregate
public class Product
{
    private UUID id;
    private String name;
    private String description;
    private Money money;

    public void setName(String name)
    {
        validateName(name);
        this.name = name;
    }
    private void validateName(String name)
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if(name.length() < 3)
            throw new IllegalArgumentException("Name must be at least 3 characters");
    }

    public void setMoney(Money money)
    {
        Objects.requireNonNull(money, "Money cannot be null");
        this.money = money;
    }

    public void setDescription(String description)
    {
        validateDescription(description);
        this.description = description;
    }

    private void validateDescription(String description)
    {
        if(description == null || description.length() < 3)
            throw new IllegalArgumentException("Description must be at least 3 characters");
        if(description.length() > 255)
            throw new IllegalArgumentException("Description length must be less than 255 characters");
    }
}
