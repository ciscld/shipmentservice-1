package com.infosys.api.shipment.events;

import java.util.UUID;

public class OrderCreatedEvent {
    public OrderCreatedEvent(UUID orderIdentifier, String name) {
        this.orderIdentifier = orderIdentifier;
        this.name = name;
    }

    private final UUID orderIdentifier;
    private final String name;


    public UUID getOrderIdentifier() {
        return orderIdentifier;
    }

    public String getName() {
        return name;
    }
}