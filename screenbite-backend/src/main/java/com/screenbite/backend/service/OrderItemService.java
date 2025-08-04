package com.screenbite.backend.service;

import com.screenbite.backend.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllItemsOfUser(int customerId);
    List<OrderItem> createItems(List<OrderItem> orderItemList);

}
