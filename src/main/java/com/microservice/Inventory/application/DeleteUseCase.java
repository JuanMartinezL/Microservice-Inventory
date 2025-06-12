package com.microservice.inventory.application;

import com.microservice.inventory.domain.IUInventoryRepository;

public class DeleteUseCase {
    private final IUInventoryRepository repository;

    public DeleteUseCase(IUInventoryRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id_product) {
        repository.deleteById(id_product);
    }
}

   
