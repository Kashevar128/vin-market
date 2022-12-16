package ru.vinogradov.spring.vin_market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vinogradov.spring.vin_market.entities.User;
import ru.vinogradov.spring.vin_market.services.OrderService;
import ru.vinogradov.spring.vin_market.services.ProductService;
import ru.vinogradov.spring.vin_market.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal) {
        User user = userService.findByUserName(principal.getName()).orElseThrow(
                () -> new RuntimeException()
        );
        orderService.createOrder(user);
    }
}
