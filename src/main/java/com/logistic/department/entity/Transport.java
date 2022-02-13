package com.logistic.department.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.logistic.department.enums.TransportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transports")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Column(name = "driver_id")
    private int driver_id;
}
