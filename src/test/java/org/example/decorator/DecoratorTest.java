package org.example.decorator;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DecoratorTest {

    @Test
    void testGetDecorator1() {

        Logger logMock = mock(Logger.class);
        IObject objectMock = mock(IObject.class);
        when(objectMock.getDecoration1()).thenReturn("Mocked Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Mocked Decoration 2");

        Decorator decorator = new Decorator(logMock, objectMock);

        decorator.getDecorator1();

        verify(logMock, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator1_version2() {
        // Arrange
        Logger logMock = mock(Logger.class);
        IObject objectMock = mock(IObject.class);

        when(objectMock.getDecoration1()).thenReturn("Mocked Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Mocked Decoration 2");

        Decorator decorator = new Decorator(logMock, objectMock);

        // Act
        decorator.getDecorator1();

        // Assert
        InOrder inOrder = inOrder(logMock);

        inOrder.verify(logMock).info("Decoration one: {}", "Mocked Decoration 1");
        inOrder.verify(logMock).info("Decoration two: {}", "Mocked Decoration 2");

        // Verifica que solo se hicieron dos llamadas al método info
        verify(logMock, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator2() {
        Logger logMock = mock(Logger.class);
        IObject objectMock = mock(IObject.class);
        IObject objectDecorationMock = mock(ObjectDecoration.class);

        when(objectMock.getDecoration1()).thenReturn("Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Decoration 2");

        when(objectDecorationMock.getDecoration1()).thenReturn("Decoration 1, Decoration1 plus");
        when(objectDecorationMock.getDecoration2()).thenReturn("Decoration 2, Decoration2 plus");

        Decorator decorator = new Decorator(logMock, objectMock);
        decorator.getDecorator2();

        verify(logMock).info("Decoration one: {}", "Decoration 1, Decoration1 plus");
        verify(logMock).info("Decoration two: {}", "Decoration 2, Decoration2 plus");
        verify(logMock, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator2_Version2() {
        // Arrange
        Logger logMock = mock(Logger.class);
        IObject objectMock = mock(IObject.class);
        IObject objectDecorationMock = mock(ObjectDecoration.class);

        when(objectMock.getDecoration1()).thenReturn("Decoration 1");
        when(objectMock.getDecoration2()).thenReturn("Decoration 2");

        when(objectDecorationMock.getDecoration1()).thenReturn("Decoration 1, Decoration1 plus");
        when(objectDecorationMock.getDecoration2()).thenReturn("Decoration 2, Decoration2 plus");

        Decorator decorator = new Decorator(logMock, objectMock);

        // Act
        decorator.getDecorator2();

        // Assert
        InOrder inOrder = inOrder(logMock);

        ArgumentCaptor<String> captor1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> captor2 = ArgumentCaptor.forClass(String.class);

        inOrder.verify(logMock).info(eq("Decoration one: {}"), captor1.capture());
        inOrder.verify(logMock).info(eq("Decoration two: {}"), captor2.capture());

        assertEquals("Decoration 1, Decoration1 plus", captor1.getValue());
        assertEquals("Decoration 2, Decoration2 plus", captor2.getValue());
    }

}