package com.cosmetelogy.converter;

import com.cosmetelogy.dto.OrderDto;
import com.cosmetelogy.dto.ProductDto;
import com.cosmetelogy.entity.Order;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderConverter {

    private final ProductConverter productConverter;

    public OrderConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public Order toLocal(Person person,OrderDto dto) {
        if (dto == null) {
            return null;
        }

        Order order = new Order();

        order.setId(dto.id());
        order.setPerson(person);
        order.setOrderStatus(dto.orderStatus());
        List<Product> products = productConverter.toLocal(dto.products());
        order.setProducts(products);

        return order;
    }

    public OrderDto toFront(Order order) {
        if (order == null) {
            return null;
        }
        List<ProductDto> productDtos = productConverter.toFront(order.getProducts());
        return new OrderDto(order.getId(), order.getOrderStatus(), productDtos);
    }

    public List<Order> toLocal(Person person, List<OrderDto> orders) {
        if (orders == null) {
            return null;
        }

        return orders.stream().map(dto->toLocal(person, dto)).toList();
    }

    public List<OrderDto> toFront(List<Order> orders) {
        if (orders == null) {
            return null;
        }

        return orders.stream().map(this::toFront).toList();
    }
}
