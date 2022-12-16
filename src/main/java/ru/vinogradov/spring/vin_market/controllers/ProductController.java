package ru.vinogradov.spring.vin_market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.spring.vin_market.dtos.ProductDto;
import ru.vinogradov.spring.vin_market.entities.Product;
import ru.vinogradov.spring.vin_market.exceptions.ResourceNotFoundException;
import ru.vinogradov.spring.vin_market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll().stream().map(product -> new ProductDto(product.getId(), product.getTitle(),
                product.getPrice())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product product = productService.findByID(id).orElseThrow(() -> new ResourceNotFoundException(
                "Продукт не найден, id:" + id));
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
