package com.javarush.task.task36.task3602;

import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class ex = null;
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class a : classes) {
            if (a.getSimpleName().equals("EmptyList")) ex = a;
        }
        return ex;
    }
}
