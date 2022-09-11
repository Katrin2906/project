package com.cosmetelogy.service;

import com.cosmetelogy.converter.ProductConverter;
import com.cosmetelogy.dto.ProductDto;
import com.cosmetelogy.entity.Product;
import com.cosmetelogy.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    public ProductService(ProductConverter productConverter, ProductRepository productRepository) {
        this.productConverter = productConverter;
        this.productRepository = productRepository;
    }

    public Long save(ProductDto dto) {
        Product product = productConverter.toLocal(dto);
        return productRepository.save(product).getId();
    }
}
