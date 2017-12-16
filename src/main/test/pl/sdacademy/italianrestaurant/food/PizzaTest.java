package pl.sdacademy.italianrestaurant.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void shouldProvideBuilder() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterDoughSetup() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        Pizza.PizzaBuilder builderAfterDough = builder.dough(Dough.SICILIAN);

        assertNotNull(builderAfterDough);
    }

    @Test
    public void shouldReturnBuilderAfterSizeSetup() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        Pizza.PizzaBuilder builderAfterDough = builder.size(Size.MUNCHIES);

        assertNotNull(builderAfterDough);
    }

    @Test
    public void shouldReturnBuilderAfterSauceSetup() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        Pizza.PizzaBuilder builderAfterDough = builder.sauce("tomato");

        assertNotNull(builderAfterDough);
    }

    @Test
    public void shouldReturnBuilderAfterToppingSetup() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        Pizza.PizzaBuilder builderAfterDough = builder.topping("pepperoni");

        assertNotNull(builderAfterDough);
    }

    @Test
    public void shouldReturnPizzaOnBuild() {
        Pizza.PizzaBuilder builder = Pizza.builder();

        Pizza pizza = builder.build();

        assertNotNull(pizza);
    }

    @Test
    public void shouldBeAbleToSetPizzaFieldsWithBuilder() {
        Dough dough = Dough.SICILIAN;
        Size size = Size.SMALL;
        String sauce = "garlic";
        String topping1 = "ham";
        String topping2 = "mushroom";

        Pizza pizza = Pizza.builder()
                .dough(dough)
                .size(size)
                .sauce(sauce)
                .topping(topping1)
                .topping(topping2).build();

        assertEquals(dough, pizza.getDough());
        assertEquals(sauce, pizza.getSauce());
        assertEquals(size, pizza.getSize());
        assertTrue(pizza.getToppings().contains(topping1));
        assertTrue(pizza.getToppings().contains(topping2));
    }
}