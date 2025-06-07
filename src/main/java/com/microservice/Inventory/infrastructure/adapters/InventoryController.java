package com.microservice.inventory.infrastructure.adapters;

import com.microservice.inventory.infrastructure.postgres.InventoryRepositoryPostgres;

import com.microservice.inventory.application.AddUseCase;
import com.microservice.inventory.application.ListUseCase;
import com.microservice.inventory.domain.InventoryDomain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class InventoryController {

    private final ListUseCase listUseCase;
    private final AddUseCase addUseCase;

    public InventoryController(InventoryRepositoryPostgres inventoryRepository) {
        this.listUseCase = new ListUseCase(inventoryRepository);
        this.addUseCase = new AddUseCase(inventoryRepository);
    }

    @GetMapping
    public List<InventoryDomain> listar() {
        return listUseCase.ejecutar();
    }

    @PostMapping
    public void crearUsuario(@RequestBody InventoryDomain  inventory) {
        addUseCase.ejecutar( inventory);
    }

    // Endpoint raíz
    @GetMapping("/")
    public String home() {
        return "Microservicio de Inventario.";
    }

    
    }

