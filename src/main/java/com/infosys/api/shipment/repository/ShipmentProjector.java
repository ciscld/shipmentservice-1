package com.infosys.api.shipment.repository;

import com.infosys.api.shipment.aggregate.Shipment;
import com.infosys.api.shipment.queries.GetShipmentQuery;
import org.axonframework.modelling.command.Repository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ShipmentProjector {
	private final Repository<Shipment> repository;

	public ShipmentProjector(Repository<Shipment> repository) {
		this.repository = repository;
	}

	@QueryHandler
	public Shipment getShipment(GetShipmentQuery query) throws InterruptedException, ExecutionException {
		CompletableFuture<Shipment> future = new CompletableFuture<Shipment>();
		repository.load("" + query.getOrderIdentifier()).execute(future::complete);
		return future.get();
	}

}
