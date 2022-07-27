package com.cosmetelogy.dto;

import com.cosmetelogy.entity.OrderStatus;

import java.util.List;

public record OrderDto(Long id,
                       OrderStatus orderStatus,
                       List<ProductDto> productDtos) {
}
