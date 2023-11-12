package org.example.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DecoratorTest {

    /*@Test
    void testGetDecorator1() {
        // Arrange
        IObject objectMock = mock(IObject.class);
        when(objectMock.getDecoration1()).thenReturn("Mocked Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Mocked Decoration 2");

        Decorator decorator = new Decorator();
        decorator.object = objectMock;

        // Act
        decorator.getDecorator1();

        // No hay una aserción específica aquí porque estamos probando el método que usa el logger, que es difícil de probar directamente.
        // Puedes inspeccionar la salida del logger si estás configurado para capturar logs en tus pruebas.
    }

    @Test
    void testGetDecorator2() {
        // Arrange
        IObject objectMock = mock(IObject.class);
        when(objectMock.getDecoration1()).thenReturn("Mocked Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Mocked Decoration 2");

        IObject objectDecorationMock = mock(IObject.class);
        when(objectDecorationMock.getDecoration1()).thenReturn("Mocked Decoration 1 Plus");
        when(objectDecorationMock.getDecoration2()).thenReturn("Mocked Decoration 2 Plus");

        Decorator decorator = new Decorator();
        decorator.object = objectMock;
        decorator.objectPlus = objectDecorationMock;

        // Act
        decorator.getDecorator2();

        // No hay una aserción específica aquí porque estamos probando el método que usa el logger, que es difícil de probar directamente.
        // Puedes inspeccionar la salida del logger si estás configurado para capturar logs en tus pruebas.
    }*/



    private List<String> logs = new ArrayList<>();
    private Logger mockLogger = Mockito.mock(Logger.class);

    @AfterEach
    void tearDown() {
        logs.clear();
    }

    @Test
    void testGetDecorator1() {
        // Arrange
        IObject objectMock = Mockito.mock(IObject.class);
        Mockito.when(objectMock.getDecoration1()).thenReturn("Mocked Decoration 1");
        Mockito.when(objectMock.getDecoration2()).thenReturn("Mocked Decoration 2");

        Mockito.when(mockLogger.isInfoEnabled()).thenReturn(true);
        Mockito.doAnswer(invocation -> {
            logs.add(invocation.getArgument(0).toString());
            return null;
        }).when(mockLogger).info(Mockito.anyString());

        Decorator decorator = new Decorator();

        // Configura el logger dinámico en Decorator
        decorator.setLogger(mockLogger);

        // Act
        decorator.getDecorator1();

        // Assert
        assertEquals(2, logs.size());
        assertEquals("Decoration one: Mocked Decoration 1", logs.get(0));
        assertEquals("Decoration two: Mocked Decoration 2", logs.get(1));
    }
}