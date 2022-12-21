package ru.vinogradov.vin.market.carts.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.vin.market.api.ProductDto;
import ru.vinogradov.vin.market.api.ResourceNotFoundException;
import ru.vinogradov.vin.market.carts.integrations.ProductServiceIntegration;
import ru.vinogradov.vin.market.carts.model.Cart;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        ProductDto productDto = productServiceIntegration.getProductById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Нужный продукт не найден"));
        tempCart.add(productDto);
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
