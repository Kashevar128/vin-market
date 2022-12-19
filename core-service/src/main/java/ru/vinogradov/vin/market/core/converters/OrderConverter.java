package ru.vinogradov.vin.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.vin.market.core.dtos.OrderDto;
import ru.vinogradov.vin.market.core.dtos.OrderItemDto;
import ru.vinogradov.vin.market.core.entities.Order;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        List<OrderItemDto> orderItemDtoList = order.getItems().stream().map(
                orderItemConverter::entityToDto).toList();
        OrderDto orderDto = new OrderDto(order.getId(), order.getUser().getUsername(), orderItemDtoList,
                order.getPhone(), order.getAddress(), order.getEmail(), order.getTotalPrice());
        return orderDto;
    }

//    public Order dtoToEntity(OrderDto orderDto) {
//
//    }
}
