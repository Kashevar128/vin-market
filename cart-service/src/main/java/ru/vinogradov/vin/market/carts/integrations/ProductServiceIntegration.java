package ru.vinogradov.vin.market.carts.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.vinogradov.vin.market.api.CartDto;
import ru.vinogradov.vin.market.api.ProductDto;
import ru.vinogradov.vin.market.api.ResourceNotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
   // private final WebClient productServiceIntegrationWebClient;
    private final RestTemplate restTemplate;

    public Optional<ProductDto> getProductById(Long id) {
        return Optional.ofNullable(restTemplate.getForObject("http://localhost:17003/vin/api/v1/products/" + id,
                ProductDto.class));
    }

//    public ProductDto getProductById(Long id) {
//        return productServiceIntegrationWebClient.get()
//                .uri("/api/v1/products" + id)
//                .retrieve()
//                .onStatus(
//                        httpStatusCode -> httpStatusCode.value() == HttpStatus.NOT_FOUND.value(),
//                        clientResponse -> Mono.error(new ResourceNotFoundException("Товар не найден в продуктовом МС"))
//                        )
//                .bodyToMono(ProductDto.class)
//                .block();
//    }


}
