package ru.vinogradov.vin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vinogradov.vin.market.core.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
