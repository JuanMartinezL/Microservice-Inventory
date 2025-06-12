
package com.microservice.inventory.infrastructure.adapters;

import com.microservice.inventory.application.Inventory;
import com.microservice.inventory.domain.InventoryDomain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.microservice.inventory.domain.IUInventoryRepository;


@Repository
public class InventoryRepositoryImpl implements IUInventoryRepository {

    private final List<InventoryDomain> user = new ArrayList<>();
    final InventoryDomain user1 = new InventoryDomain();
    

    public InventoryDomain save(InventoryDomain user) {
        user.add(user);
        return user;
    }

    public List<InventoryDomain> consultarTodos() {
        user1.setDescription("ejemplo@ejemplo.com");
        user1.setId_product(Long.MIN_VALUE);
        user1.setName_product("Hola");
        user.add(user1);
        return user;
    }

    public void guardar(Inventory user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public InventoryDomain update(InventoryDomain inventory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Long id_product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}