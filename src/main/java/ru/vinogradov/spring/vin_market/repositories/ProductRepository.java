package ru.vinogradov.spring.vin_market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vinogradov.spring.vin_market.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
