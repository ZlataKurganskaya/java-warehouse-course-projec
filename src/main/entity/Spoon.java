package src.main.entity;

public class Spoon extends Product<Spoon> {
    private String material;

    public Spoon(int id, double price, String name, String color, String material) {
        super(id, price, name, color);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + " Material: " +material;
    }
}
