package pl.sdacademy.italianrestaurant.food;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodFactoryTest {
    private FoodFactory foodFactory;

    @Before
    public void init() {
        foodFactory = new FoodFactory();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldProducePizza() {
        OrderElement pizzaOrder = mock(OrderElement.class);
        when(pizzaOrder.getElementType()).thenReturn("pizza");

        Food createdFood = foodFactory.prepareFood(pizzaOrder);
    }

    @Test
    public void shouldProducePizzaWithIngredients() {
        // given
        OrderElement pizzaOrder = mock(OrderElement.class);
        when(pizzaOrder.getElementType()).thenReturn("pizza");
        Map<String, Set<String>> ingredients = new HashMap<>();
        ingredients.put("dough", new HashSet<String>() {{add("neapolitan");}});
        ingredients.put("sauce", new HashSet<String>() {{add("tomato");}});
        ingredients.put("topping", new HashSet<String>() {{add("mozzarella");}});
        when(pizzaOrder.getSpecifics()).thenReturn(ingredients);
        //when
        Food createdFood = foodFactory.prepareFood(pizzaOrder);

        //then
        assertNotNull(createdFood);
        assertTrue(createdFood instanceof Pizza);
        Pizza pizza = (Pizza) createdFood;
        assertEquals(Dough.NEAPOLITAN, pizza.getDough());
        assertEquals("tomato", pizza.getSauce());
        assertTrue(pizza.getToppings().contains("mozzarella"));
    }

    @Test
    public void shouldProducePastaWithIngredients() {
        //given
        OrderElement pastaOrder = mock(OrderElement.class);
        when(pastaOrder.getElementType()).thenReturn("pasta");
        Map<String, Set<String>> ingredients = new HashMap<>();
        ingredients.put("pastaType", new HashSet<String>(){{add("ravioli");}});
        ingredients.put("sauce", new HashSet<String>(){{add("garlic");}});
        ingredients.put("spices", new HashSet<String>(){{add("mayo");}});
        ingredients.put("parmesan", new HashSet<String>(){{add("true");}});
        when(pastaOrder.getSpecifics()).thenReturn(ingredients);
        //when
        Food preparedFood = foodFactory.prepareFood(pastaOrder);
        //then
        assertNotNull(preparedFood);
        assertTrue(preparedFood instanceof Pasta);
        Pasta pasta = (Pasta) preparedFood;
        assertEquals(PastaType.RAVIOLI, pasta.getPastaType());
        assertEquals("garlic", pasta.getSauce());
        assertTrue(pasta.getSpices().contains("mayo"));
        assertTrue(pasta.isParmesan());
    }
}








