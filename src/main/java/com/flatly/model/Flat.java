package com.flatly.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "flat")
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double price;

    @Column
    private String description;

    @Column
    private Float distance;

    @Column(columnDefinition = "json")
    private List<String> amenities;

    @Column
    private String availability;

    @Column(columnDefinition = "json")
    private List<String> images;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
