package com.turkcell.ecommerce_cqrs.domain.product.model;

import java.util.Objects;

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

    // Kontrollü Üretim -> Ctor'ı private yapıyoruz
    // Bu nesne yalnızca benim vereceğim fabrika metotları ile oluşturulsun.
    private Product(ProductId id, String name, String description, Money money, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.money = money;
        this.stock = stock;
    }
    // Static Factory Method (idiom)
    public static Product create(String name, String description, Money money, Integer stock)
    {
        validateName(name);
        validateDescription(description);
        Objects.requireNonNull(money, "Money cannot be null");
        validateStock(stock);

        return new Product(ProductId.generate(), name, description, money, stock);
    }

    // İş yapan methodlar.
    public void rename(String name)
    {
        validateName(name);
        this.name = name;
    }
    // Setter => Değer override etmek
    // Worker => İşlem sonucu değerleri değiştiren.
    public void dispatch(Integer quantityToDispatch)
    {
        if(quantityToDispatch == null || quantityToDispatch <= 0)
            throw new IllegalArgumentException("Quantity to dispatch must be positive.");
        if(this.stock < quantityToDispatch)
            throw new IllegalArgumentException("Insufficient stock.");
        this.stock -= quantityToDispatch;
    }

    public void restock(Integer quantityToRestock)
    {
        if (quantityToRestock == null || quantityToRestock <= 0)
            throw new IllegalArgumentException("Quantity to dispatch must be positive.");
        this.stock += quantityToRestock;
    }

    public void changePrice(Money newPrice)
    {
        Objects.requireNonNull(newPrice, "Price cannot be null");
        this.money = newPrice;
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
