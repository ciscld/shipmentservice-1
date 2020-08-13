package com.infosys.api.shipment.events.listeners;

import com.infosys.api.shipment.commands.SendShipment;
import com.infosys.api.shipment.events.ItemCreatedEvent;
import com.infosys.api.shipment.events.OrderCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ItemCreatedEventListener {
    private final CommandGateway commandGateway;

    public ItemCreatedEventListener(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void onEvent(ItemCreatedEvent event) {

        System.out.println("Received Order Created Event:" + event.getItemName() + " on thread named "
                + Thread.currentThread().getName());

        commandGateway.send(new SendShipment(event.getCartIdentifier(), event.getItemName()));
        //return "Saved";
    }
}
