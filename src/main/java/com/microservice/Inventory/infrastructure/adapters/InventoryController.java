package com.microservice.inventory.infrastructure.adapters;

import com.microservice.inventory.infrastructure.postgres.InventoryRepositoryPostgres;

import com.microservice.inventory.application.AddUseCase;
import com.microservice.inventory.application.DeleteUseCase;
import com.microservice.inventory.application.ListUseCase;
import com.microservice.inventory.application.UpdateUseCase;
import com.microservice.inventory.domain.InventoryDomain;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final ListUseCase listUseCase;
    private final AddUseCase addUseCase;
    private final UpdateUseCase updateUseCase;
    private final DeleteUseCase deleteUseCase;

    public InventoryController(InventoryRepositoryPostgres inventoryRepository) {
        this.listUseCase = new ListUseCase(inventoryRepository);
        this.addUseCase = new AddUseCase(inventoryRepository);
        this.updateUseCase = new UpdateUseCase(inventoryRepository);
        this.deleteUseCase = new DeleteUseCase(inventoryRepository);
    }
//Obtener los productos
    @GetMapping
    public List<InventoryDomain> listar() {
        return listUseCase.ejecutar();
    }
    // Obtener un producto por su ID
@GetMapping("/{id_product}")
public ResponseEntity<InventoryDomain> obtenerProductoPorId(@PathVariable Long id_product) {
    List<InventoryDomain> productos = listUseCase.ejecutar();
    return productos.stream()
            .filter(p -> p.getId_product().equals(id_product))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
//Crear producto
    @PostMapping
    public void crearUsuario(@RequestBody InventoryDomain  inventory) {
        addUseCase.ejecutar( inventory);
    }


    // Endpoint raíz
    @GetMapping("/")
    public String home() {
        return "Microservicio de Inventario.";
    }
    
    //ELiminar 
    @DeleteMapping("/{id_product}")
public ResponseEntity<Void> eliminarProducto(@PathVariable Long id_product) {
    deleteUseCase.delete(id_product);
    return ResponseEntity.noContent().build();
}

//actualzar producto
@PutMapping("/{id_product}")
public ResponseEntity<InventoryDomain> actualizarProducto(
        @PathVariable Long id_product,
        @RequestBody InventoryDomain product) {
    InventoryDomain actualizado = updateUseCase.actualizar(product);
    return ResponseEntity.ok(actualizado);
}

}
