package ru.vinogradov.spring.vin_market.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.spring.vin_market.dtos.OrderItemDto;
import ru.vinogradov.spring.vin_market.entities.OrderItem;

@Component
@RequiredArgsConstructor
public class OrderItemConverter {

    public OrderItemDto entityToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto(orderItem.getId(), orderItem.getProduct().getTitle(),
                orderItem.getQuantity(), orderItem.getPricePerProduct(),
                orderItem.getPrice());
        return orderItemDto;
    }

//    public OrderItem dtoToEntity (OrderItemDto orderItemDto) {
//      return null;
//    }
}
