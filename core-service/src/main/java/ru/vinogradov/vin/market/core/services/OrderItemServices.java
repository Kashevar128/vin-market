package ru.vinogradov.vin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.vin.market.api.CartDto;
import ru.vinogradov.vin.market.api.CartItemDto;
import ru.vinogradov.vin.market.api.ResourceNotFoundException;
import ru.vinogradov.vin.market.core.entities.Order;
import ru.vinogradov.vin.market.core.entities.OrderItem;
import ru.vinogradov.vin.market.core.entities.Product;
//import ru.vinogradov.vin.market.core.model.Cart;
//import ru.vinogradov.vin.market.core.model.CartItem;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServices {

    private final ProductService productService;

    public List<OrderItem> createListOrderItems(CartDto cartDto, Order order) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartItemDto cartItemDto : cartDto.getItems()) {
            OrderItem orderItem = new OrderItem();
            Product product = productService.findByID(cartItemDto.getProductId()).orElseThrow(
                    () -> new ResourceNotFoundException("Продукт для позиции заказа не найден")
            );
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setPricePerProduct(cartItemDto.getPricePerProduct());
            orderItem.setPrice(cartItemDto.getPrice());
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }
}
