package ru.vinogradov.vin.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.vinogradov.vin.market.api.CartDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    public Optional<CartDto> getCurrentCart() {
        return Optional.ofNullable(restTemplate.getForObject("http://localhost:17004/vin-carts/api/v1/cart",
                CartDto.class));
    }

    public void clearCurrentCart() {
        //restTemplate.getForEntity("http://localhost:17004/vin-carts/api/v1/cart/clear", Void.class);
        restTemplate.delete("http://localhost:17004/vin-carts/api/v1/cart");
    }
}
