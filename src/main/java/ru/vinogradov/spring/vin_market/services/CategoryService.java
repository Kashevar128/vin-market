package ru.vinogradov.spring.vin_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.spring.vin_market.entities.Category;
import ru.vinogradov.spring.vin_market.repositories.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
