package com.javarush.test.level14.lesson08.bonus01;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new IllegalArgumentException());
        exceptions.add(new TimeoutException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new ClassCastException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new KeyAlreadyExistsException());
        exceptions.add(new TooManyListenersException());
        exceptions.add(new InputMismatchException());
        exceptions.add(new IOException());

    }
}
