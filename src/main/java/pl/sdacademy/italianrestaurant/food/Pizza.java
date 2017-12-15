package pl.sdacademy.italianrestaurant.food;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pizza implements Food, Bakeable {

    private Dough dough;
    private Size size;
    private String sauce;
    private Set<String> toppings;

    public Pizza() {
        toppings = new HashSet<>();
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public Set<String> getToppings() {
        return toppings;
    }

    public void addToppings(String topping) {
        toppings.add("toppings");
    }

    public void bake(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", size=" + size +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
