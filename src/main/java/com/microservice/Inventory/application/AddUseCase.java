package com.microservice.inventory.application;

import com.microservice.inventory.domain.InventoryDomain;
import com.microservice.inventory.domain.IUInventoryRepository;

public class AddUseCase {
    private final IUInventoryRepository repo;

    public AddUseCase(IUInventoryRepository repo) {
        this.repo = repo;
    }

    public void ejecutar(InventoryDomain  inventory) {
        repo.save( inventory);
    }
}
