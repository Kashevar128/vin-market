package ru.vinogradov.vin.market.api;

import java.util.List;

public class OrderDto {
    private Long id;
    private String userName;
    private List<OrderItemDto> items;
    private String phone;
    private String address;
    private String email;
    private int totalPrice;

    public OrderDto() {
    }

    public OrderDto(Long id, String userName, List<OrderItemDto> items, String phone,
                    String address, String email, int totalPrice) {
        this.id = id;
        this.userName = userName;
        this.items = items;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
