package com.infosys.api.shipment.aggregate;

import com.infosys.api.shipment.commands.SendShipment;
import com.infosys.api.shipment.events.OrderShippedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@Aggregate
public class Shipment {

    @AggregateIdentifier
    private UUID orderIdentifier;

    private String name;

    protected Shipment() {
        // For Axon instantiation
    }

    @CommandHandler
    public Shipment(SendShipment cmd) {
        Assert.notNull(cmd.getOrderIdentifier(), "ID should not be null");
        Assert.notNull(cmd.getName(), "Name should not be null");

        AggregateLifecycle.apply(new OrderShippedEvent(cmd.getOrderIdentifier(), cmd.getName()));
    }

    public UUID getOrderIdentifier() {
        return orderIdentifier;
    }

    public String getName() {
        return name;
    }


    @EventSourcingHandler
    private void handleCreatedEvent(OrderShippedEvent event) {
        orderIdentifier = event.getOrderIdentifier();
        name = event.getName();
    }

}
