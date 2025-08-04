package com.screenbite.backend.repository;

import com.screenbite.backend.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    List<OrderItem> getAllItems(int customerId);
    List<OrderItem> createItems(List<OrderItem> orderItemList);


}
