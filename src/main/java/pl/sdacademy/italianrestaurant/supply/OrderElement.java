package pl.sdacademy.italianrestaurant.supply;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderElement {
    private final String elementType;
    private final Map<String, Set<String>> specifics;

    public OrderElement(String elementType) {
        this.elementType = elementType;
        this.specifics = new HashMap<>();
    }

    public void addSpecifics(String type, String specific) {
        Set<String> collectionOfSpecificsForType = new HashSet<>();
        collectionOfSpecificsForType.add(specific);
        specifics.merge(type, collectionOfSpecificsForType, (oldSpecifics, newSpecifics) -> {
            oldSpecifics.addAll(newSpecifics);
            return oldSpecifics;
        });
    }

    public String getElementType() {
        return elementType;
    }

    public Map<String, Set<String>> getSpecifics() {
        return specifics;
    }
}
