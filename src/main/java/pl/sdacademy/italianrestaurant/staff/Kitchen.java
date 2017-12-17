package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.supply.Order;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Kitchen {
    private List<FoodObserver> foodObservers;
    private List<OrderObserver> orderObservers;
    private Queue<Order> orders;
    private Queue<Food> foods;

    public Kitchen() {
        foodObservers = new ArrayList<>();
        orderObservers = new ArrayList<>();
        orders = new ConcurrentLinkedQueue<>();
        foods = new ConcurrentLinkedQueue<>();
    }

    public void register(FoodObserver observer) {
        foodObservers.add(observer);
    }

    public void register(OrderObserver observer) {
        orderObservers.add(observer);
    }

    public void unregister(FoodObserver observer) {
        foodObservers.remove(observer);
    }

    public void unregister(OrderObserver observer) {
        orderObservers.remove(observer);
    }

    public void addFood(Food food) {
        foods.add(food);
        foodObservers.forEach(FoodObserver::update);
    }

    public void addOrder(Order order) {
        orders.add(order);
        orderObservers.forEach(OrderObserver::update);
    }

    public Optional<Order> getOrder() {
        return Optional.ofNullable(orders.poll());
    }

    public Optional<Food> getFood() {
        return Optional.ofNullable(foods.poll());
    }
}
