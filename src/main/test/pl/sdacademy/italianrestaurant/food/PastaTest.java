package pl.sdacademy.italianrestaurant.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class PastaTest {

    @Test
    public void shouldProvideBuilder() {
        Pasta.PastaBuilder builder = Pasta.builder();

        assertNotNull(builder);
    }


}