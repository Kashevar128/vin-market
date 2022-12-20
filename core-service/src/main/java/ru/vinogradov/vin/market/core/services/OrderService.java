package ru.vinogradov.vin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vinogradov.vin.market.api.CartDto;
import ru.vinogradov.vin.market.api.ResourceNotFoundException;
import ru.vinogradov.vin.market.core.entities.Order;
import ru.vinogradov.vin.market.core.entities.OrderItem;
import ru.vinogradov.vin.market.core.entities.User;
import ru.vinogradov.vin.market.core.integrations.CartServiceIntegration;
import ru.vinogradov.vin.market.core.repositories.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderItemServices orderItemServices;
    private final OrderRepository orderRepository;
    private final CartServiceIntegration cartServiceIntegration;

    @Transactional
    public Order createOrder(User user) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart().orElseThrow(
                () -> new ResourceNotFoundException("Не удается получить корзину пользователя."));
        Order order = new Order();
        order.setUser(user);
        order.setPhone(user.getPhone());
        order.setEmail(user.getEmail());
        order.setAddress(user.getAddress());
        order.setTotalPrice(cartDto.getTotalPrice());
        List<OrderItem> orderItemList = orderItemServices.createListOrderItems(cartDto, order);
        order.setItems(orderItemList);
        orderRepository.save(order);
        cartServiceIntegration.clearCurrentCart();
        return order;
    }

}
