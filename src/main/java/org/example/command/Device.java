package org.example.command;

import java.util.logging.Logger;

public class Device {

    private static final Logger LOGGER = Logger.getLogger(Device.class.getName());

    public void turnOn() {
        LOGGER.info("Device turning on");
    }

    public void turnOff() {
        LOGGER.info("Device turning off");
    }
}
