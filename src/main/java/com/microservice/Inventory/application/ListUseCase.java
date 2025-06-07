package com.microservice.inventory.application;

import com.microservice.inventory.domain.InventoryDomain;
import java.util.List;
import com.microservice.inventory.domain.IUInventoryRepository;


public class ListUseCase {
    private final IUInventoryRepository repo;

    public ListUseCase(IUInventoryRepository repo) {
        this.repo = repo;
    }

    public List<InventoryDomain> ejecutar() {
        return repo.consultarTodos();
    }
}


