package com.flatly.model;

import lombok.Data;

@Data
public class BookingRequest {
    private Booking booking;
    private Long flatId;
    private Long userId;
}
