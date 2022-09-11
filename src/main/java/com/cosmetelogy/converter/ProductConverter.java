package com.cosmetelogy.converter;

import com.cosmetelogy.dto.ProductDto;
import com.cosmetelogy.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConverter {
    public Product toLocal(ProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setId(dto.id());
        product.setProductPrice(dto.productPrice());
        product.setProductName(dto.productName());
        product.setProducer(dto.producer());
        product.setCompound(dto.compound());
        product.setVolume(dto.volume());

        return product;
    }

    public ProductDto toFront(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductDto(product.getId(), product.getProductName(), product.getVolume(), product.getProductPrice(), product.getCompound(), product.getProducer());
    }

    public List<Product> toLocal(List<ProductDto> products) {
        if (products == null) {
            return null;
        }

        return products.stream()
                .map(this::toLocal)
                .toList();
    }

    public List<ProductDto> toFront(List<Product> products) {
        if (products == null) {
            return null;
        }

        return products.stream()
                .map(this::toFront)
                .toList();
    }
}
