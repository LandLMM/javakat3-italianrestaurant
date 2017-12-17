package pl.sdacademy.italianrestaurant;

import pl.sdacademy.italianrestaurant.staff.Chef;
import pl.sdacademy.italianrestaurant.staff.Kitchen;
import pl.sdacademy.italianrestaurant.staff.Waiter;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        new Waiter(kitchen, "Antonio").start();
        new Waiter(kitchen, "Giulia").start();
        new Chef(kitchen, "Luigi").start();
        new Chef(kitchen, "Francesco").start();
        new Chef(kitchen, "Mario").start();
        System.out.println("PREGO restaurant is working!");
    }
}
