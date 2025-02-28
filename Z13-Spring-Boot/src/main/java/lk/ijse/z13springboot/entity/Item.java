package lk.ijse.z13springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity public class Item {
    @Id
    private int id;
    private String name;
    private double qty;
    private double price;

    public Item() {
    }

    public Item(int id, String name, double qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Item(int itemId) {
        this.id = itemId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}