package src.main.entity;

public class Cup extends Product<Cup>{
    private int volume;
     public Cup(int id, double price, String name, String color, int volume){
         super(id,price,name,color);
         this.volume = volume;
     }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}


