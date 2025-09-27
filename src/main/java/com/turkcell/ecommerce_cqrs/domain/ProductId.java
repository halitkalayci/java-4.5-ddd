package com.turkcell.ecommerce_cqrs.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Bir yazılım nesnesi, "ağ üzerinde", "cache" içerisinde "dosya" sisteminde yazılabilir-okunabilir olmalıdır.
public record ProductId(UUID value) implements Serializable {
    public ProductId {
        Objects.requireNonNull(value, "Value for ProductId cannot be null");
    }

    // Fabrika metodu
    // Nesnenin kendi içinde kendi oluşturulma mekanizmasını yazması.
    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }
}

// Serialize-Deserialize -> nesne => byte[] , byte[] -> nesne
// abc.save -> Kod nesnelerinin serialize edilmiş hali
// abc.save -> ProductId(); Deserialize