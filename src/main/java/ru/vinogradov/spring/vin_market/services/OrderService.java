package ru.vinogradov.spring.vin_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vinogradov.spring.vin_market.entities.Order;
import ru.vinogradov.spring.vin_market.entities.OrderItem;
import ru.vinogradov.spring.vin_market.entities.User;
import ru.vinogradov.spring.vin_market.model.Cart;
import ru.vinogradov.spring.vin_market.repositories.OrderRepository;

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
