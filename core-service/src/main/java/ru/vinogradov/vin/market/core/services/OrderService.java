package ru.vinogradov.vin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.vin.market.core.entities.Order;
import ru.vinogradov.vin.market.core.entities.OrderItem;
import ru.vinogradov.vin.market.core.entities.User;
import ru.vinogradov.vin.market.core.model.Cart;
import ru.vinogradov.vin.market.core.repositories.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderItemServices orderItemServices;
    private final OrderRepository orderRepository;

    public Order createOrder(User user, Cart cart) {
        Order order = new Order();
        order.setUser(user);
        order.setPhone(user.getPhone());
        order.setEmail(user.getEmail());
        order.setAddress(user.getAddress());
        order.setTotalPrice(cart.getTotalPrice());
        List<OrderItem> listOrderItems = orderItemServices.createListOrderItems(cart, order);
        order.setItems(listOrderItems);
        orderRepository.save(order);
        return order;
    }

}
