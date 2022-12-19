package ru.vinogradov.spring.vin_market.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public void addQuantity(int delta) {
        quantity += delta;
        price = pricePerProduct * quantity;
    }

    public boolean reduceQuantity(int delta) {
        if (quantity > 1) {
            quantity -= delta;
            price = pricePerProduct * quantity;
            return true;
        }
        return false;
    }
}
