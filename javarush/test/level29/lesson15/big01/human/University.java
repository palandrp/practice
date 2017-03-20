package com.javarush.test.level29.lesson15.big01.human;

import java.util.List;

public class University {
    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student a: students) {
            if (a.getAverageGrade() == grade) return a;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student max = students.get(0);
        double grade = 0;
        for (Student a: students) {
            if (a.getAverageGrade() > grade) {
                grade = a.getAverageGrade();
                max = a;
            }
        }
        return max;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public Student getStudentWithMinAverageGrade() {
        Student min = students.get(0);
        double grade = Double.MAX_VALUE;
        for (Student a: students) {
            if (a.getAverageGrade() < grade) {
                grade = a.getAverageGrade();
                min = a;
            }
        }
        return min;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
