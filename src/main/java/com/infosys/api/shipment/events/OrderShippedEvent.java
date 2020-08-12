package com.infosys.api.shipment.events;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderShippedEvent {
	private final UUID orderIdentifier;
	private final String name;
}
