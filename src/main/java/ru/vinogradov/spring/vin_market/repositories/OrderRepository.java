package ru.vinogradov.spring.vin_market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vinogradov.spring.vin_market.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
