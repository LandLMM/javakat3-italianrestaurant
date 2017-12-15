package pl.sdacademy.italianrestaurant.supply;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderElement> elements;

    public Order() {
        this.elements = new ArrayList<>();
    }

    public void addElement(OrderElement element) {
        elements.add(element);
    }

    public List<OrderElement> getElements() {
        return elements;
    }
}
