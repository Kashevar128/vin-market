package ru.vinogradov.spring.vin_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.spring.vin_market.entities.Order;
import ru.vinogradov.spring.vin_market.entities.OrderItem;
import ru.vinogradov.spring.vin_market.entities.Product;
import ru.vinogradov.spring.vin_market.exceptions.ResourceNotFoundException;
import ru.vinogradov.spring.vin_market.model.Cart;
import ru.vinogradov.spring.vin_market.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServices {

    private final ProductService productService;

    public List<OrderItem> createListOrderItems(Cart cart, Order order) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            Product product = productService.findByID(cartItem.getProductId()).orElseThrow(
                    () -> new ResourceNotFoundException("Продукт для позиции заказа не найден")
            );
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPricePerProduct(cartItem.getPricePerProduct());
            orderItem.setPrice(cartItem.getPrice());
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }
}
