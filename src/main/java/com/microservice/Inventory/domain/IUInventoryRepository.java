
package com.microservice.inventory.domain;

import com.microservice.inventory.domain.InventoryDomain;
import java.util.List;

public interface IUInventoryRepository {
    InventoryDomain save(InventoryDomain  inventory);
    List<InventoryDomain> consultarTodos();

   
}
