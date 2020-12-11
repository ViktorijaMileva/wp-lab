package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
}
