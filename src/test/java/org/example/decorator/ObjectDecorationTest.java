package org.example.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectDecorationTest {

    private IObject baseObject;
    private IObject decoratedObject;
    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setUp() {
        baseObject = new ObjectImp();
        decoratedObject = new ObjectDecoration(baseObject);
        autoCloseable = () -> { //implenta la interfaz AutoCloseable
        };
    }

    @AfterEach
    public void setClose() throws Exception {
        autoCloseable.close(); //cierra el recurso después de las pruebas.
    }

    @Test
    void testGetDecoration1() {
        String result = decoratedObject.getDecoration1();

        assertEquals("Decoration 1, Decoration1 plus", result);
    }

    @Test
    void testGetDecoration2() {
        String result = decoratedObject.getDecoration2();

        assertEquals("Decoration 2, Decoration2 plus", result);
    }
}
