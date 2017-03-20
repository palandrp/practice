package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Naatsms on 29.01.2017.
 */
public abstract class UniversityPerson extends Human {
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
