package pl.sdacademy.italianrestaurant.food;

import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.Set;

public class FoodFactory {
    public Food prepareFood(OrderElement orderElement) {
        switch (orderElement.getElementType()) {
            case "pizza" :
                if (isValidForPizza(orderElement)) {
                    return producePizza(orderElement);
                }
                break;
            case "pasta" :
                if (isValidForPasta(orderElement)) {
                    return producePasta(orderElement);
                }
        }
        throw new IllegalArgumentException("No valid specifics");
    }

    private Food producePasta(OrderElement orderElement) {
        String pastaType = orderElement.getSpecifics().get("pastaType").iterator().next();
        String sauce = orderElement.getSpecifics().get("sauce").iterator().next();
        String parmesan = orderElement.getSpecifics().get("parmesan").iterator().next();
        Set<String> spices = orderElement.getSpecifics().get("spices");

        Pasta pasta = Pasta.builder()
                .pastaType(PastaType.valueOf(pastaType.toUpperCase()))
                .sauce(sauce)
                .parmesan(Boolean.valueOf(parmesan))
                .spices(spices).build();
        return pasta;
    }

    private Food producePizza(OrderElement orderElement) {
        String dough = orderElement.getSpecifics().get("dough").iterator().next();
        String sauce = orderElement.getSpecifics().get("sauce").iterator().next();
        Set<String> toppings = orderElement.getSpecifics().get("topping");

        Pizza.PizzaBuilder pizzaBuilder = Pizza.builder()
                .dough(Dough.valueOf(dough.toUpperCase()))
                .sauce(sauce)
                .size(Size.MEDIUM);
        toppings.forEach(pizzaBuilder::topping);
        Pizza pizza = pizzaBuilder.build();
        return pizza;
    }

    private boolean isValidForPizza(OrderElement orderElement) {
        return orderElement.getSpecifics().containsKey("dough")
                && orderElement.getSpecifics().containsKey("sauce")
                && orderElement.getSpecifics().containsKey("topping");
    }

    private boolean isValidForPasta(OrderElement orderElement) {
        return orderElement.getSpecifics().containsKey("pastaType")
                && orderElement.getSpecifics().containsKey("sauce")
                && orderElement.getSpecifics().containsKey("spices")
                && orderElement.getSpecifics().containsKey("parmesan");
    }
}
