package ru.vinogradov.vin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vinogradov.vin.market.core.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
