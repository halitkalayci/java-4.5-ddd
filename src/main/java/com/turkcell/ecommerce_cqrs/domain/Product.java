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
        this.name = name;
        this.description = description;
        this.money = money;
        this.stock = stock;
    }
    public static Product create(String name, String description, Money money, Integer stock)
    {
        validateName(name);
        validateDescription(description);
        Objects.requireNonNull(money, "Money cannot be null");
        validateStock(stock);

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
    private static void validateStock(Integer stock)
    {
        if (stock == null || stock <= 0)
            throw new IllegalArgumentException("Stock cannot be null or negative value");
    }
    private static void validateDescription(String description)
    {
        if(description == null || description.length() < 3)
            throw new IllegalArgumentException("Description must be at least 3 characters");
        if(description.length() > 255)
            throw new IllegalArgumentException("Description length must be less than 255 characters");
    }
    private static void validateName(String name)
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if(name.length() < 3)
            throw new IllegalArgumentException("Name must be at least 3 characters");
    }

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Money money() {
        return money;
    }

    public Integer stock() {
        return stock;
    }
}
