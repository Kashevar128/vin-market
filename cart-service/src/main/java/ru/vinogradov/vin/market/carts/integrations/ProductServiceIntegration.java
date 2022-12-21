package ru.vinogradov.vin.market.carts.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.vinogradov.vin.market.api.ProductDto;
import ru.vinogradov.vin.market.api.ResourceNotFoundException;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final WebClient productServiceIntegrationWebClient;

    public ProductDto getProductById(Long id) {
        return productServiceIntegrationWebClient.get()
                .uri("/api/v1/products" + id)
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode.value() == HttpStatus.NOT_FOUND.value(),
                       // clientResponse -> clientResponse.bodyToMono(AppError.class).map(appError -> new ResourceNotFoundException("Товар не найден в продуктовом МС");
                        clientResponse -> Mono.error(new ResourceNotFoundException("Товар не найден в продуктовом МС"))
                        )
                .bodyToMono(ProductDto.class)
                .block();
    }


}
