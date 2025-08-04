package com.screenbite.backend.repository;

import com.screenbite.backend.model.Booking;
import com.screenbite.backend.model.OrderItem;
import com.screenbite.backend.model.mapper.BookingMapper;
import com.screenbite.backend.service.OrderItemService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepository{

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final OrderItemService orderItemService;

    public BookingRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, OrderItemService orderItemService) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.orderItemService = orderItemService;
    }

    @Override
    public List<Booking> getAllBookings() {
        String sql = "SELECT id, customer_id, table_id, movie_id, date, day, show_time, prepaid, payment_method, total_amount FROM reservation ";
        List<Booking> bookings = jdbcTemplate.query(sql, new BookingMapper());

        // For each booking, fetch order items
        bookings.forEach(booking -> booking.setOrderItem(orderItemService.getAllItemsOfUser(booking.getCustomerId())));

        return bookings;
    }

    @Override
    public List<Booking> getAllBookingsByUser(int id) {
        StringBuilder query = new StringBuilder("SELECT id, customer_id, table_id, movie_id, date, day, show_time, prepaid, " +
                "payment_method, total_amount FROM reservation WHERE customer_id =:customer_id");
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("customer_id",id);
        List<Booking> bookings = namedParameterJdbcTemplate.query(query.toString(), param,new BookingMapper());

        // Fetch order items for each booking
        bookings.forEach(booking -> booking.setOrderItem(orderItemService.getAllItemsOfUser(booking.getCustomerId())));

        return bookings;
    }

    @Override
    public Booking createBooking(Booking booking) {

        StringBuilder query = new StringBuilder(
                "INSERT INTO reservation (customer_id, table_id, movie_id, date, day, show_time, prepaid, payment_method, total_amount) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );

//        double totalPrice = booking.getOrderItem().stream()
//                .mapToDouble(OrderItem::getItemPrice)
//                .sum();

        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getCustomerId());
            ps.setString(2, booking.getTableId());
            ps.setInt(3, booking.getMovieId());
            ps.setDate(4, new java.sql.Date(booking.getDate().getTime()));
            ps.setString(5, booking.getDay());
            ps.setString(6, booking.getShowTime());
            ps.setBoolean(7, booking.isPrepaid());
            ps.setString(8, booking.getPaymentMethod());
            ps.setDouble(9, booking.getOrderItem().stream()
                    .mapToDouble(OrderItem::getItemPrice)
                    .sum());
            return ps;
        }, key);

        if (key.getKey() != null) {
            booking.setId(key.getKey().intValue());
        }

        // Save order items if present
        Optional.ofNullable(booking.getOrderItem())
                .filter(list -> !list.isEmpty())
                .ifPresent(orderItems -> {
                    // Set bookingId for each order item (using stream)
                    orderItems.forEach(item -> item.setId(booking.getId()));
                    orderItemService.createItems(orderItems); // Use the service layer
                });

        return booking;

    }

    @Override
    public Booking editBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking deleteBooking(int bookingId) {
        return null;
    }
}
