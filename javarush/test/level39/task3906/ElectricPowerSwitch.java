package com.javarush.task.task39.task3906;

public class ElectricPowerSwitch {
    private Component component;

    public ElectricPowerSwitch(Component component) {
        this.component = component;
    }

    public void press() {
        System.out.println("Pressed the power switch.");
        if (component.isOn()) {
            component.turnOff();
        } else {
            component.turnOn();
        }
    }
}
