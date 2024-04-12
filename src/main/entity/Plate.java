package src.main.entity;

public class Plate extends Product<Plate> {
    private String size;

    public Plate(int id, double price, String name, String color, String size){
        super(id, price, name, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}



