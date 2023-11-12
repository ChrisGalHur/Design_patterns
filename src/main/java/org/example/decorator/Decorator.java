package org.example.decorator;

import org.slf4j.Logger;

public class Decorator {
    //VARIABLES
    private final Logger log;
    private final IObject object;
    private final IObject objectPlus;

    public Decorator(Logger log, IObject object) {
        this.log = log;
        this.object = object;
        this.objectPlus = new ObjectDecoration(object);
    }

    public void getDecorator1() {
        log.info("Decoration one: {}", object.getDecoration1());
        log.info("Decoration two: {}", object.getDecoration2());
    }

    public void getDecorator2() {
        log.info("Decoration one: {}", objectPlus.getDecoration1());
        log.info("Decoration two: {}", objectPlus.getDecoration2());
    }
}
