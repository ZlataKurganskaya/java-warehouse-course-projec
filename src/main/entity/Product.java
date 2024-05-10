package src.main.entity;

import java.util.Objects;

public abstract class Product <Self extends Product<Self>> {
    private int id;
    private double price;
    private String name;
    private String color;

    public Product(int id, double price, String name, String color) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public Product() { }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product<?> product = (Product<?>) obj;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(color, product.color);
    }

    @Override
    public String toString() {
        return "Product: " +name + ". Color: " +color + ". Price: " +price +" Id: " +id ;
    }
}


