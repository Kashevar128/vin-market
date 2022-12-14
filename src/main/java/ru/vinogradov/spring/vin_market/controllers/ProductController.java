package ru.vinogradov.spring.vin_market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.spring.vin_market.dtos.ProductDto;
import ru.vinogradov.spring.vin_market.entities.Product;
import ru.vinogradov.spring.vin_market.exceptions.AppError;
import ru.vinogradov.spring.vin_market.exceptions.ResourceNotFoundException;
import ru.vinogradov.spring.vin_market.services.ProductService;

import java.util.List;
import java.util.Optional;
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

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.findByID(id);
//         if (!product.isPresent()) {
//             ResponseEntity<AppError> err = new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
//                     "Продукт не найден, id:" + id), HttpStatus.NOT_FOUND);
//             return err;
//         }
//        return new ResponseEntity<>(product.get(), HttpStatus.OK);
//    }

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
