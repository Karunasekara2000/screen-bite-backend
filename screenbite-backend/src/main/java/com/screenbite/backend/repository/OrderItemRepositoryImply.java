package com.screenbite.backend.repository;

import com.screenbite.backend.model.OrderItem;
import com.screenbite.backend.model.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImply implements OrderItemRepository{

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<OrderItem> getAllItems(int customerId) {

        StringBuilder query = new StringBuilder("SELECT id, customer_id, category, name, " +
                "item_price FROM orders WHERE customer_id =:id");
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", customerId);
        return namedParameterJdbcTemplate.query(query.toString(), param, new OrderMapper());
    }

    @Override
    public List<OrderItem> createItems(List<OrderItem> orderItemList) {

        StringBuilder query = new StringBuilder("INSERT INTO orders(customer_id, category, name, " +
                "item_price) VALUES( ?, ?, ?, ?)");

        orderItemList.forEach(orderItem -> {
            KeyHolder key = new GeneratedKeyHolder();
            jdbcTemplate.update(con->{
                PreparedStatement ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,orderItem.getCustomerId());
                ps.setString(2,orderItem.getCategory());
                ps.setString(3,orderItem.getName());
                ps.setDouble(4,orderItem.getItemPrice());
                return ps;
            },key);

            if(key.getKey() != null){
                orderItem.setId(key.getKey().intValue());
            }
        });

        return orderItemList;
    }
}
