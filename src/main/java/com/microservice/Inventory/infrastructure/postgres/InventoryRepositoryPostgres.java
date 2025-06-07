
package com.microservice.inventory.infrastructure.postgres;

import com.microservice.inventory.application.Inventory;
import com.microservice.inventory.domain.InventoryDomain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.microservice.inventory.domain.IUInventoryRepository;


@Repository
public class InventoryRepositoryPostgres implements IUInventoryRepository {
                                                                                                                                                                                      
    private static final String URL = "jdbc:postgresql://localhost:5432/inventory_products";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgresql";

    @Override
public InventoryDomain save(InventoryDomain inventory_products) {
    String sql = "INSERT INTO inventory_products (name_product, description, price, stock) VALUES (?, ?, ?, ?) RETURNING id_product";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, inventory_products.getName_product());
        stmt.setString(2, inventory_products.getDescription());
        stmt.setFloat(3, inventory_products.getPrice());
        stmt.setLong(4, inventory_products.getStock());

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            inventory_products.setId_product(rs.getLong("id_product"));
        }

    } catch (SQLException e) {
        throw new RuntimeException("Error al guardar el producto", e);
    }

    return inventory_products;
}

@Override
public List<InventoryDomain> consultarTodos() {
    List<InventoryDomain> inventory_products = new ArrayList<>();
    String sql = "SELECT id_product, name_product, description, price, stock FROM inventory_products";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            InventoryDomain u = new InventoryDomain();
            u.setId_product(rs.getLong("id_product"));
            u.setName_product(rs.getString("name_product"));
            u.setDescription(rs.getString("description"));
            u.setPrice(rs.getFloat("price"));
            u.setStock(rs.getLong("stock"));
            inventory_products.add(u);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Error al consultar los usuarios", e);
    }

    return inventory_products;
}

public void guardar(Inventory inventory_products) {
    throw new UnsupportedOperationException("Not supported yet.");
}
}
