package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Naatsms on 20.02.2017.
 */
public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age > TeenGirl.MAX_AGE) return new Woman();
        if (age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE) return new TeenGirl();
        if (age <= KidGirl.MAX_AGE) return new KidGirl();

        return new Woman();

    }
}
