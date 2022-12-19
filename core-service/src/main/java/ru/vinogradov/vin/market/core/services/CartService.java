package ru.vinogradov.vin.market.core.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.vin.market.core.entities.Product;
import ru.vinogradov.vin.market.core.model.Cart;
import ru.vinogradov.vin.market.core.exceptions.ResourceNotFoundException;

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

    public void remove(Long productId) {
        tempCart.remove(productId);
    }

    public void addQuantity(Long productId) {
        tempCart.addQuantityCartItem(productId);
    }

    public void reduceQuantity(Long productId) {
        tempCart.reduceQuantityCartItem(productId);
    }

    public void clear() {
        tempCart.clear();
    }
}
