package com.infosys.api.shipment.models;


import java.util.UUID;

public class ShipmentBean {
	private  UUID shipmentIdentifier;
	private  String name;

	public ShipmentBean(){

	}
	public ShipmentBean(UUID shipmentIdentifier, String name) {
		this.shipmentIdentifier = shipmentIdentifier;
		this.name = name;
	}

	public UUID getShipmentIdentifier() {
		return shipmentIdentifier;
	}

	public void setShipmentIdentifier(UUID shipmentIdentifier) {
		this.shipmentIdentifier = shipmentIdentifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
