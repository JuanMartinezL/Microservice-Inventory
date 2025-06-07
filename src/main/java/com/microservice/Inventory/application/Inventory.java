
package com.microservice.inventory.application;
import jakarta.persistence.Lob;


public class Inventory {
    private Long id_product;
    private String name_product;
    @Lob //indica que el campo puede tener mucho texto
    private String description;
    private Float price;
    private Long stock;
    
    //Constructor vacío (requerido por frameworks como Spring)
    public Inventory () {}
    //Constructor completo
     public Inventory (Long id_product,String name_product, String description, Float price, Long stock){
         this.id_product= id_product;
         this.name_product= name_product;
         this.description= description;
         this.price= price;
         this.stock= stock;
         
     }
    //Getters y Setters
      public Long getId_product() { return id_product; }
    public void setId(Long id_product) { this.id_product = id_product; }

    public String getName_product() { return name_product; }
    public void setNombre(String name_product) { this.name_product = name_product; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public Long getStock() { return stock; }
    public void setStock(Long stock) { this.stock = stock; }

    /*public void setName(String hola) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
