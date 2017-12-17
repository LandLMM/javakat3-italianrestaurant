package pl.sdacademy.italianrestaurant.food;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pizza implements Food, Bakeable {

    private final Dough dough;
    private final Size size;
    private final String sauce;
    private final Set<String> toppings;

    private Pizza(PizzaBuilder pizzaBuilder) {
        dough = pizzaBuilder.dough;
        size = pizzaBuilder.size;
        sauce = pizzaBuilder.sauce;
        toppings = pizzaBuilder.toppings;
    }

    public Dough getDough() {
        return dough;
    }

    public Size getSize() {
        return size;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getToppings() {
        return toppings;
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

    public static PizzaBuilder builder() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {

        private Dough dough;
        private Size size;
        private String sauce;
        private Set<String> toppings;

        private PizzaBuilder() {
            toppings = new HashSet<>();
        }

        public PizzaBuilder dough(Dough dough) {
            this.dough = dough;
            return this;
        }

        public PizzaBuilder size(Size size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder topping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
