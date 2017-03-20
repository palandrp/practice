package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        Annotation ans = c.getAnnotation(PrepareMyTest.class);
        if (ans == null) return false;
        PrepareMyTest ann = (PrepareMyTest)ans;
        String[] starr = ann.fullyQualifiedNames();
        for (String str : starr) {
            System.out.println(str);
        }
        return true;
    }

    public static boolean printValues(Class c) {
        Annotation ans = c.getAnnotation(PrepareMyTest.class);
        if (ans == null) return false;
        PrepareMyTest ann = (PrepareMyTest)ans;
        Class[] starr = ann.value();
        for (Class str : starr) {
            System.out.println(str.getSimpleName());
        }
        return true;
    }
}
