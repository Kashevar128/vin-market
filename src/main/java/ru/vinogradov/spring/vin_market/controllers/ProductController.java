package ru.vinogradov.spring.vin_market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.spring.vin_market.converters.ProductConverter;
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
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll().stream().map(productConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product product = productService.findByID(id).orElseThrow(() -> new ResourceNotFoundException(
                "Продукт не найден, id:" + id));
        return productConverter.entityToDto(product);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createNewProduct(productDto);
        ProductDto productDto1 = productConverter.entityToDto(product);
        return productDto1;
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
