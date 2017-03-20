package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> eventClass;

    public Generator(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    T newInstance() {
        T t = null;
        try {
            t = eventClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
