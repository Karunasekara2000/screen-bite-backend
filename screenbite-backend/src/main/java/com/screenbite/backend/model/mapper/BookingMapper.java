package com.screenbite.backend.model.mapper;

import com.screenbite.backend.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Booking.builder()
                .id(rs.getInt("id"))
                .customerId(rs.getInt("customer_id"))
                .tableId(rs.getString("table_id"))
                .movieId(rs.getInt("movie_id"))
                .date(rs.getDate("date"))
                .day(rs.getString("day"))
                .showTime(rs.getString("show_time"))
                .prepaid(rs.getBoolean("prepaid"))
                .paymentMethod(rs.getString("payment_method"))
                .build();
    }
}
