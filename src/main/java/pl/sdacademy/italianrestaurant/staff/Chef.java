package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.*;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Chef {
    private FoodFactory factory = new FoodFactory();

    public List<Food> prepareOrderedFood(Order order) {
        return order.getElements().stream().map(factory::prepareFood).collect(Collectors.toList());
    }
}
