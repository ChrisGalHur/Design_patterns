package org.example.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Decorator {
    private static final Logger log = LoggerFactory.getLogger(Decorator.class);
    IObject object = new ObjectImp();
    IObject objectPlus = new ObjectDecoration(object);

    public void getDecorator1() {
        log.info("Decoration one: {}", object.getDecoration1());
        log.info("Decoration two: {}", object.getDecoration2());
    }

    public void getDecorator2() {
        log.info("Decoration one: {}", objectPlus.getDecoration1());
        log.info("Decoration two: {}", objectPlus.getDecoration2());
    }

}
