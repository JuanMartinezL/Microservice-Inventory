package com.microservice.inventory.domain;

public class InventoryDomain{
    private Long id_product;
    private String name_product;
    private String description;
    private Float price; 
    private Long stock; 

    public InventoryDomain() {}

    public InventoryDomain(Long id_product, String name_product, String description, Float price, Long stock) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Getters y setters
    public Long getId_product() { return id_product; }
    public void setId_product(Long id_product) { this.id_product = id_product; }

    public String getName_product() { return name_product; }
    public void setName_product(String name) { this.name_product = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public Long getStock() { return stock; }
    public void setStock(Long stock) { this.stock = stock; }

    
    public  static Object Metodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     
    }

    public void add(InventoryDomain inventory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*public void setId_product(long Long) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
