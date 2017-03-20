package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        checkCause(e);
    }

    public void checkCause(Throwable e) {
        if (e.getCause() == null) System.out.println(e);
        else {
            checkCause(e.getCause());
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }

}
