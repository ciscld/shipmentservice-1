package com.infosys.api.shipment.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
public class SendShipment {
	@TargetAggregateIdentifier
	private final UUID orderIdentifier;
	private final String name;

}
