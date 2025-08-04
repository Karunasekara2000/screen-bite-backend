package com.screenbite.backend.service;

import com.screenbite.backend.model.OrderItem;
import com.screenbite.backend.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> getAllItemsOfUser(int customerId) {
        return orderItemRepository.getAllItems(customerId);
    }

    @Override
    public List<OrderItem> createItems(List<OrderItem> orderItemList) {
        return orderItemRepository.createItems(orderItemList);
    }
}
