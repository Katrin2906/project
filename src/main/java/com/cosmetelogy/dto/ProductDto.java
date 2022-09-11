package com.cosmetelogy.dto;

import java.math.BigDecimal;

public record ProductDto(Long id,
                         String productName,
                         Double volume,
                         BigDecimal productPrice,
                         String compound,
                         String producer) {
}
