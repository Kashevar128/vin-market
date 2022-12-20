package ru.vinogradov.vin.market.core.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.vin.market.core.converters.OrderConverter;
import ru.vinogradov.vin.market.core.entities.Order;
import ru.vinogradov.vin.market.core.entities.User;
import ru.vinogradov.vin.market.core.services.OrderService;
import ru.vinogradov.vin.market.core.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
//    private final UserService userService;
//    private final OrderService orderService;
//    private final CartService cartService;
//    private final OrderConverter orderConverter;
//
//    @PostMapping
//    public OrderDto createOrder(Principal principal) {
//        if (principal == null) {
//            log.info("Чтобы сделать заказ, нужно залогиниться");
//            return null;
//        }
//        User user = userService.findByUserName(principal.getName()).orElseThrow(
//                () -> new ResourceNotFoundException("Не найден пользователь при создании заказа")
//        );
//        Cart currentCart = cartService.getCurrentCart();
//        Order order = orderService.createOrder(user, currentCart);
//        OrderDto orderDto = orderConverter.entityToDto(order);
//        return orderDto;
//    }
}
