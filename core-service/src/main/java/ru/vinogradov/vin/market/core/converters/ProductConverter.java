package ru.vinogradov.vin.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.vin.market.api.ProductDto;
import ru.vinogradov.vin.market.core.entities.Product;
import ru.vinogradov.vin.market.core.services.CategoryService;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryService categoryService;

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(),
                product.getPrice(), product.getCategory().getTitle());
    }
}
