package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(method1());
    }

    public static String method1()
    {
        System.out.println(method2());
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        return arr[2].getMethodName();
    }

    public static String method2()
    {
        System.out.println(method3());
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        return arr[2].getMethodName();
    }

    public static String method3()
    {
        System.out.println(method4());
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        return arr[2].getMethodName();
    }

    public static String method4()
    {
        System.out.println(method5());
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        return arr[2].getMethodName();

    }

    public static String method5()
    {
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        return arr[2].getMethodName();
    }
}
