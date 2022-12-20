package ru.vinogradov.vin.market.carts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.vin.market.api.CartDto;
import ru.vinogradov.vin.market.carts.converters.CartConverter;
import ru.vinogradov.vin.market.carts.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @DeleteMapping()
    public void clearCart() {
        cartService.clear();
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.remove(id);
    }

    @GetMapping
    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(cartService.getCurrentCart());
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
