package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.*;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Waiter extends Thread implements FoodObserver {

    private Kitchen kitchen;
    private String name;
    private boolean isWorking = false;
    private boolean thereIsFoodToBeServed = false;

    public Waiter(Kitchen kitchen, String name) {
        this.kitchen = kitchen;
        this.name = name;
        kitchen.register(this);
    }

    public String getWaiterName() {
        return name;
    }

    @Override
    public void run() {
        isWorking = true;
        while (isWorking) {
            if (customerIsWaiting()) {
                handleCustomer();
            }
            if (thereIsFoodToBeServed) {
                kitchen.getFood().ifPresent(this::serveFood);
                thereIsFoodToBeServed = false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // nothing to do
            }
        }
    }

    private boolean customerIsWaiting() {
        synchronized (kitchen) {
            try {
                int amountOfChars = System.in.available();
                byte[] readChars = new byte[amountOfChars];
                System.in.read(readChars);
                return amountOfChars > 0;
            } catch (IOException e) {
                System.out.println("Unable to check client availability: " + e.getMessage());
            }
            return false;
        }
    }

    private void serveFood(Food foodToBeServed) {
        System.out.println(name + ": Here is your food " + foodToBeServed.toString());
    }

    @Override
    public void interrupt() {
        isWorking = false;
        super.interrupt();
    }

    public void handleCustomer() {
        int userSelection = 0;
        scrollTheScreen();
        System.out.println(name + ": Hi, welcome in Prego Italian Restaurant! Would you like...");
        System.out.println("1. Take order");
        System.out.println("2. Pay the bill");
        userSelection = getUserSelection();
        switch (userSelection) {
            case 1:
                takeOrder();
                break;
            case 2:
                payTheBill();
                break;
        }
    }

    private void takeOrder() {
        scrollTheScreen();
        Order order = new Order();
        System.out.println(name + ": I can recommend you delicious pizzas!");
        System.out.println("1. Neapolitan with mozzarella, grana padano and tomato sauce");
        System.out.println("2. New York with mozzarella, prosciutto cotto, mushrooms and tomato sauce");
        System.out.println("3. Sicilian with mozzarella, salami milano, olives and tomato sauce");
        int userSelection = getUserSelection();
        switch (userSelection) {
            case 1:
                System.out.println(name + ": Neapolitan! So traditional, so delicious! I'll bring it soon.");
                OrderElement firstPizza = new OrderElement("pizza");
                firstPizza.addSpecifics("dough", "neapolitan");
                firstPizza.addSpecifics("sauce", "tomato");
                firstPizza.addSpecifics("topping", "mozzarella");
                firstPizza.addSpecifics("topping", "grana padano");
                order.addElement(firstPizza);
                kitchen.addOrder(order);
                break;
            case 2:
                System.out.println(name + ": Meh, another yankee pizza. Fine.");
                OrderElement secondPizza = new OrderElement("pizza");
                secondPizza.addSpecifics("dough", "new_york");
                secondPizza.addSpecifics("sauce", "tomato");
                secondPizza.addSpecifics("topping", "mozzarella");
                secondPizza.addSpecifics("topping", "prosciutto cotto");
                secondPizza.addSpecifics("topping", "mushrooms");
                order.addElement(secondPizza);
                kitchen.addOrder(order);
                break;
            case 3:
                System.out.println(name + ": Nonna used to cut it into squares. I'll bring it soon.");
                OrderElement thirdPizza = new OrderElement("pizza");
                thirdPizza.addSpecifics("dough", "sicilian");
                thirdPizza.addSpecifics("sauce", "tomato");
                thirdPizza.addSpecifics("topping", "mozzarella");
                thirdPizza.addSpecifics("topping", "salami milano");
                thirdPizza.addSpecifics("topping", "olives");
                order.addElement(thirdPizza);
                kitchen.addOrder(order);
                break;
            default:
                System.out.println("Mamma mia! That's not even a pizza! Vaffanculo!");
        }
    }

    private void payTheBill() {
        scrollTheScreen();
        System.out.println(name + ": That will be XXX total.");
    }

    private int getUserSelection() {
        InputStreamReader reader = new InputStreamReader(System.in);
        int readSelection = '0';
        try {
            readSelection = reader.read();
        } catch (IOException e) {
            System.out.println("Could not read input");
        }
        return readSelection - '0';
    }

    private void scrollTheScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    @Override
    public void update() {
        thereIsFoodToBeServed = true;
    }
}
