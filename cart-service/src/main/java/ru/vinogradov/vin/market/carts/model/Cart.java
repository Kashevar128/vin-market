package ru.vinogradov.vin.market.carts.model;

import lombok.Data;
import ru.vinogradov.vin.market.api.ProductDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(ProductDto productDto) {
        for (CartItem item : items) {
            if (productDto.getId().equals(item.getProductId())) {
                item.addQuantity(1);
                recalculate();
                return;
            }
        }
        items.add(new CartItem(productDto.getId(), productDto.getTitle(),
                1, productDto.getPrice(), productDto.getPrice()));
        recalculate();
    }

    public void remove(Long productId) {
        if (items.removeIf(cartItem -> cartItem.getProductId().equals(productId))) {
            recalculate();
        }
    }

    public void addQuantityCartItem(Long productId) {
        for (CartItem item : items) {
            if (item.getProductId().equals(productId)) {
                item.addQuantity(1);
                recalculate();
                return;
            }
        }
    }

    public void reduceQuantityCartItem(Long productId) {
        for (CartItem item : items) {
            if (item.getProductId().equals(productId))
                if (!item.reduceQuantity(1)) {
                    items.remove(item);
                }
            recalculate();
            return;
        }
    }

    public void clear() {
        items.clear();
        totalPrice = 0;
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
