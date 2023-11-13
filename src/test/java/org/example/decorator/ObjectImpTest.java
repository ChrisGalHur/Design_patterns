package org.example.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectImpTest {
    //VARIABLES
    private ObjectImp baseObject;
    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        baseObject = new ObjectImp();
        closeable = () -> { //implenta la interfaz AutoCloseable
        };
    }

    @AfterEach
    public void setClose() throws Exception {
        closeable.close(); //cierra el recurso después de las pruebas.
    }

    @Test
    void testGetDecoration1() {
        assertEquals("Decoration 1", baseObject.getDecoration1());
    }

    @Test
    void testGetDecoration2() {
        assertEquals("Decoration 2", baseObject.getDecoration2());
    }
}
