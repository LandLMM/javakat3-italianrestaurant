package pl.sdacademy.italianrestaurant.staff;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pl.sdacademy.italianrestaurant.food.FoodFactory;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ChefTest {

    @Mock
    private FoodFactory factory;
    @Mock
    private Kitchen kitchen;
    @InjectMocks
    private Chef ramsey;

    @Before
    public void init() {
        ramsey = new Chef(kitchen, "Gordon");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldUseFoodFactory() {
        //given
        Order order = mock(Order.class);
        OrderElement orderElement = mock(OrderElement.class);
        List<OrderElement> orderElements = new ArrayList<>();
        orderElements.add(orderElement);
        when(order.getElements()).thenReturn(orderElements);
        //when
        ramsey.prepareOrderedFood(order);
        //then
        verify(factory).prepareFood(any());
    }



    @Test
    public void shouldUseFoodFactoryMultipleTimes() {
        //given
        Order order = mock(Order.class);
        OrderElement orderElement1 = mock(OrderElement.class);
        OrderElement orderElement2 = mock(OrderElement.class);
        OrderElement orderElement3 = mock(OrderElement.class);
        List<OrderElement> orderElements = new ArrayList<>();
        orderElements.add(orderElement1);
        orderElements.add(orderElement2);
        orderElements.add(orderElement3);
        when(order.getElements()).thenReturn(orderElements);
        //when
        ramsey.prepareOrderedFood(order);
        //then
        verify(factory, times(3)).prepareFood(any());
    }










//    @Test
//    public void shouldUseFoodFactoryMultipleTimes() {
//        //given
//        Order order = mock(Order.class);
//        List<OrderElement> orderElements = new ArrayList<>();
//        orderElements.add(mock(OrderElement.class));
//        orderElements.add(mock(OrderElement.class));
//        orderElements.add(mock(OrderElement.class));
//        when(order.getElements()).thenReturn(orderElements);
//        //when
//        ramsey.prepareOrderedFood(order);
//        //then
//        verify(factory, times(3)).prepareFood(any());
//    }

















}