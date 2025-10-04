package com.turkcell.ecommerce_cqrs.domain.product.policy;


public interface ProductNameUniquePolicy {
    boolean isUnique(String name);
}
