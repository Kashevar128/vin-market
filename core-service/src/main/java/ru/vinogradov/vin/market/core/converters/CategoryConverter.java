package ru.vinogradov.vin.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vinogradov.vin.market.api.CategoryDto;
import ru.vinogradov.vin.market.core.entities.Category;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryConverter {
    private final ProductConverter productConverter;

    public CategoryDto entityToDto(Category category) {
        return new CategoryDto(category.getId(), category.getTitle(), category.getProducts().stream()
                .map(productConverter::entityToDto).collect(Collectors.toList()));
    }
}
