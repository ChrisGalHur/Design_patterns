package org.example.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DecoratorTest {
    //VARIABLES
    @Mock
    private Logger log;
    @Mock
    private IObject baseObject;
    @Mock
    private IObject decoratedObject;
    @InjectMocks
    private Decorator decorator;
    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        decorator = new Decorator(log, baseObject);
        decoratedObject = mock(ObjectDecoration.class);
    }

    @AfterEach
    public void setClose() throws Exception {
        closeable.close();
    }

    @Test
    void testGetDecorator1() {
        when(baseObject.getDecoration1()).thenReturn("Decoration 1");

        decorator.getDecorator1();

        verify(log, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator1_version2() {
        when(baseObject.getDecoration1()).thenReturn("Decoration 1");
        when(baseObject.getDecoration2()).thenReturn("Decoration 2");

        decorator.getDecorator1();

        InOrder inOrder = inOrder(log);
        inOrder.verify(log).info("Decoration one: {}", "Decoration 1");
        inOrder.verify(log).info("Decoration two: {}", "Decoration 2");

        verify(log, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator2() {
        when(baseObject.getDecoration1()).thenReturn("Decoration 1");
        when(baseObject.getDecoration2()).thenReturn("Decoration 2");

        when(decoratedObject.getDecoration1()).thenReturn("Decoration 1, Decoration1 plus");
        when(decoratedObject.getDecoration2()).thenReturn("Decoration 2, Decoration2 plus");

        decorator.getDecorator2();

        verify(log).info("Decoration one: {}", "Decoration 1, Decoration1 plus");
        verify(log).info("Decoration two: {}", "Decoration 2, Decoration2 plus");
        verify(log, times(2)).info(anyString(), (Object) any());
    }

    @Test
    void testGetDecorator2_Version2() {
        when(baseObject.getDecoration1()).thenReturn("Decoration 1");
        when(baseObject.getDecoration2()).thenReturn("Decoration 2");

        when(decoratedObject.getDecoration1()).thenReturn("Decoration 1, Decoration1 plus");
        when(decoratedObject.getDecoration2()).thenReturn("Decoration 2, Decoration2 plus");

        decorator.getDecorator2();

        InOrder inOrder = inOrder(log);

        ArgumentCaptor<String> captor1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> captor2 = ArgumentCaptor.forClass(String.class);

        inOrder.verify(log).info(eq("Decoration one: {}"), captor1.capture());
        inOrder.verify(log).info(eq("Decoration two: {}"), captor2.capture());

        assertEquals("Decoration 1, Decoration1 plus", captor1.getValue());
        assertEquals("Decoration 2, Decoration2 plus", captor2.getValue());
    }

}