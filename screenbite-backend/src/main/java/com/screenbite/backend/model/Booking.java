package com.screenbite.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {

    private int id;
    private int customerId;
    private String tableId;
    private int movieId;
    private Date date;
    private List<OrderItem> orderItem;
    private boolean prepaid;
    private String paymentMethod;
    private double totalAmount;

}
