package com.infosys.api.shipment.controller;

import com.infosys.api.shipment.commands.SendShipment;
import com.infosys.api.shipment.models.ShipmentBean;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentRestController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public ShipmentRestController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/shipment/send")
    public String sendShipment(@RequestBody ShipmentBean shipment) {
        commandGateway.send(new SendShipment(shipment.getShipmentIdentifier(), shipment.getName()));
        return "Saved";
    }
}
