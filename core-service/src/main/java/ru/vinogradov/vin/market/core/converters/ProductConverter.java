package ru.vinogradov.vin.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.vin.market.core.dtos.ProductDto;
import ru.vinogradov.vin.market.core.entities.Category;
import ru.vinogradov.vin.market.core.entities.Product;
import ru.vinogradov.vin.market.core.exceptions.ResourceNotFoundException;
import ru.vinogradov.vin.market.core.services.CategoryService;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryService categoryService;

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(),
                product.getPrice(), product.getCategory().getTitle());
    }

    public Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(
                () -> new ResourceNotFoundException("Категория не найдена")
        );
        return product;
    }
}
