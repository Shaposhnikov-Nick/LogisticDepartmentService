package com.logistic.department.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportType {
    CAR("CAR"),
    TRUCK("TRUCK"),
    BUS("BUS");

    private String transportType;

    TransportType(String transportType) {
        this.transportType = transportType;
    }

    @JsonValue
    public String getTransportType() {
        return transportType;
    }
}
