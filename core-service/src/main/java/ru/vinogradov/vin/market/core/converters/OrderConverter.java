package ru.vinogradov.vin.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.vin.market.api.OrderDto;
import ru.vinogradov.vin.market.api.OrderItemDto;
import ru.vinogradov.vin.market.core.entities.Order;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        List<OrderItemDto> orderItemDtoList = order.getItems().stream().map(
                orderItemConverter::entityToDto).toList();
        return new OrderDto(order.getId(), order.getUser().getUsername(), orderItemDtoList,
                order.getPhone(), order.getAddress(), order.getEmail(), order.getTotalPrice());
    }

}
