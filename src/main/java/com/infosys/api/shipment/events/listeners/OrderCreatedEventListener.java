package com.infosys.api.shipment.events.listeners;

import com.infosys.api.shipment.commands.SendShipment;
import com.infosys.api.shipment.events.OrderCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedEventListener {
    private final CommandGateway commandGateway;

    public OrderCreatedEventListener(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void onEvent(OrderCreatedEvent event) {

        System.out.println("Received Order Created Event:" + event.getName() + " on thread named "
                + Thread.currentThread().getName());

        commandGateway.send(new SendShipment(event.getOrderIdentifier(), event.getName()));
        //return "Saved";
    }
}
