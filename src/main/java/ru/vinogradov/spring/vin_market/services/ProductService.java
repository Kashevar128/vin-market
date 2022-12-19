package ru.vinogradov.spring.vin_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vinogradov.spring.vin_market.dtos.ProductDto;
import ru.vinogradov.spring.vin_market.entities.Category;
import ru.vinogradov.spring.vin_market.entities.Product;
import ru.vinogradov.spring.vin_market.exceptions.ResourceNotFoundException;
import ru.vinogradov.spring.vin_market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByID(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());

        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() ->
                new ResourceNotFoundException("Категория не найдена")
        );
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }
}
