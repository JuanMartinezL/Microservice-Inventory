package com.microservice.inventory.application;

import com.microservice.inventory.domain.IUInventoryRepository;
import com.microservice.inventory.domain.InventoryDomain;

public class UpdateUseCase {
    private final IUInventoryRepository repository;

    public UpdateUseCase(IUInventoryRepository repository) {
        this.repository = repository;
    }

    public InventoryDomain actualizar(InventoryDomain inventory) {
        return repository.update(inventory); // o usar save() 
    }
}
