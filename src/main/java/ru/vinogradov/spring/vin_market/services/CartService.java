package ru.vinogradov.spring.vin_market.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.spring.vin_market.dtos.Cart;
import ru.vinogradov.spring.vin_market.entities.Product;
import ru.vinogradov.spring.vin_market.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        Product product = productService.findByID(productId).orElseThrow(
                () -> new ResourceNotFoundException("Не удается добавить продукт с id: " + productId +
                        " в корзину. Продукт не найден"));
        tempCart.add(product);
    }
}
