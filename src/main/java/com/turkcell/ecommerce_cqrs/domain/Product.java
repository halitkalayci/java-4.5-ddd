package com.turkcell.ecommerce_cqrs.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

// Domain Object
// Saf Java.

// Aggregate
public class Product
{
    private final ProductId id; // Bu özel bi yapı mı? Yoksa sadece değer mi?
    private String name;
    private String description;
    private Money money;
    private Integer stock; // Integer -> Nesne, int (primitive type)

    // Kontrollü Yaratım -> Ctor'ı private yapıyoruz
    // Bu nesne yalnızca benim vereceğim fabrika metotları ile oluşturulsun.
    private Product(ProductId id, String name, String description, Money money, Integer stock) {
        this.id = id;
        setName(name);
        setDescription(description);
        setMoney(money);
        setStock(stock);
    }

    public static Product create(String name, String description, Money money, Integer stock)
    {
        return new Product(ProductId.generate(), name, description, money, stock);
    }

    public void setName(String name)
    {
        validateName(name);
        this.name = name;
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
    public void setStock(Integer stock)
    {
        validateStock(stock);
        this.stock = stock;
    }

    private void validateStock(Integer stock)
    {
        if (stock == null || stock <= 0)
            throw new IllegalArgumentException("Stock cannot be null or negative value");
    }
    private void validateDescription(String description)
    {
        if(description == null || description.length() < 3)
            throw new IllegalArgumentException("Description must be at least 3 characters");
        if(description.length() > 255)
            throw new IllegalArgumentException("Description length must be less than 255 characters");
    }
    private void validateName(String name)
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if(name.length() < 3)
            throw new IllegalArgumentException("Name must be at least 3 characters");
    }
}
