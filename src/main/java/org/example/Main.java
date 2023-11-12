package org.example;

import org.example.decorator.Decorator;
import org.example.decorator.IObject;
import org.example.decorator.ObjectImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        //VARIABLES DECORATOR
        Logger log = LoggerFactory.getLogger(Decorator.class);
        IObject object = new ObjectImp();

        //CALL DECORATOR
        Decorator decorator = new Decorator(log, object);
        decorator.getDecorator1();
        decorator.getDecorator2();
    }
}