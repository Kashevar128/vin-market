package ru.vinogradov.vin.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vinogradov.vin.market.core.model.Cart;
import ru.vinogradov.vin.market.core.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clear();
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.remove(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/cartItem/add/{id}")
    public void addQuantity(@PathVariable Long id) {
        cartService.addQuantity(id);
    }

    @GetMapping("/cartItem/reduce/{id}")
    public void reduceQuantity(@PathVariable Long id) {
        cartService.reduceQuantity(id);
    }


}
