package com.infosys.api.shipment.queries;

import lombok.Data;

import java.util.UUID;

@Data
public class GetShipmentQuery {
	private final UUID orderIdentifier;
}
