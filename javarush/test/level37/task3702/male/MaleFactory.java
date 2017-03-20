package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Naatsms on 20.02.2017.
 */
public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age > TeenBoy.MAX_AGE) return new Man();
        if (age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE) return new TeenBoy();
        if (age <= KidBoy.MAX_AGE) return new KidBoy();

        return new Man();

    }
}
