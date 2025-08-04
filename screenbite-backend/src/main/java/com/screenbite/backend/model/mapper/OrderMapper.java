package com.screenbite.backend.model.mapper;

import com.screenbite.backend.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrderItem.builder()
                .id(rs.getInt("id"))
                .customerId(rs.getInt("customer_id"))
                .category(rs.getString("category"))
                .name(rs.getString("name"))
                .itemPrice(rs.getDouble("item_price"))
                .build();
    }
}
