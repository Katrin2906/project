package com.cosmetelogy.dto;

import java.math.BigDecimal;

public record ProductDto(Long id,
                         String productName,
                         Double volume,
                         BigDecimal price,
                         String compound,
                         String producer) {
}
