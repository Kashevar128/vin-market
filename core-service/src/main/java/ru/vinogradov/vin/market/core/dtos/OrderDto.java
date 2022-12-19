package ru.vinogradov.vin.market.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String userName;
    private List<OrderItemDto> items;
    private String phone;
    private String address;
    private String email;
    private int totalPrice;
}
