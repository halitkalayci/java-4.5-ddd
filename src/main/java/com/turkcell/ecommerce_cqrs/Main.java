package com.turkcell.ecommerce_cqrs;

import com.turkcell.ecommerce_cqrs.domain.Money;
import com.turkcell.ecommerce_cqrs.domain.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product product = Product.create(
                "Ürün 1",
                "Ürün 1 açıklaması",
                new Money(BigDecimal.valueOf(300), "TRY"),
                100
        );
        product.setName("Ürün 2");
        System.out.println(product.name());

        // stok düşme... getstok-quantity -> setStock()
    }
}
