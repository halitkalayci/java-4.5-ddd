package com.turkcell.ecommerce_cqrs.interfaces.console;

import com.turkcell.ecommerce_cqrs.domain.product.model.Money;
import com.turkcell.ecommerce_cqrs.domain.product.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product product = Product.create(
                "Ürün 1",
                "Ürün 1 açıklaması",
                new Money(BigDecimal.valueOf(300), "TRY"),
                100
        );
        product.rename("Ürün 2");
        System.out.println(product.name());



        // stok düşme... getstok-quantity -> setStock()
    }
}

// Bireysel Ödev => Domain Driven Design hakkında 3+ sayfalık bol örnekli bir yazı oluşturmanız
// .pdf yapıp yüklemeniz.