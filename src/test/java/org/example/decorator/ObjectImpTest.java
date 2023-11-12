package org.example.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectImpTest {

    private ObjectImp object;
    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setUp() {
        object = new ObjectImp();
        autoCloseable = () -> { //implenta la interfaz AutoCloseable
        };
    }

    @AfterEach
    public void setClose() throws Exception {
        autoCloseable.close(); //cierra el recurso después de las pruebas.
    }

    @Test
    void testGetDecoration1() {
        assertEquals("Decoration 1", object.getDecoration1());
    }

    @Test
    void testGetDecoration2() {
        assertEquals("Decoration 2", object.getDecoration2());
    }
}
