package pl.sdacademy.italianrestaurant.staff;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.italianrestaurant.food.Food;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KitchenTest {

    private Kitchen kitchen;

    @Before
    public void init() {
        kitchen = new Kitchen();
    }

    @Test
    public void shouldUpdateFoodObserverWhenNewFoodAppears() {
        // given
        FoodObserver foodObserver = mock(FoodObserver.class);
        Food food = mock(Food.class);
        kitchen.register(foodObserver);
        //when
        kitchen.addFood(food);
        //then
        verify(foodObserver).update();
    }

    @Test
    public void shouldUpdateAllFoodObservesWhenNewFoodAppears() {
        //given
        FoodObserver foodObserver1 = mock(FoodObserver.class);
        FoodObserver foodObserver2 = mock(FoodObserver.class);
        Food food = mock(Food.class);
        kitchen.register(foodObserver1);
        kitchen.register(foodObserver2);
        //when
        kitchen.addFood(food);
        //then
        verify(foodObserver1).update();
        verify(foodObserver2).update();
    }

}