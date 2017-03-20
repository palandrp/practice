package com.javarush.test.level26.lesson08.task02;

/* Мудрый человек думает раз, прежде чем два раза сказать.
Все методы класса Solution должны быть потоково-безопасными.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными трэдами.
synchronized(this) для этого не подходит, используйте другой объект для лока.
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;
    final Object first = new Object();
    final Object second = new Object();

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (first) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (second) {
            return var3 + var4;
        }
    }

    static class Holder {
        int a;
        int b;

        public Holder(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
