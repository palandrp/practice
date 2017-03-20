package com.javarush.test.level20.lesson10.bonus01;

/*
Алгоритмы-числа

Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
На выполнение дается 10 секунд и 50 МБ памяти.

*/
import java.util.TreeSet;

public class Solution {
    public static int[] getNumbers(int N) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < N; i++) {
            if (isUnique(i)) {
                int sum = povSum(i);
                if (isArmstrong(sum) && sum < N) set.add(sum);
            }
        }

        int[] result = new int[set.size()];

        for (int i = 0; i < result.length; i++) {
           result[i] = set.pollFirst();
        }

        return result;
    }

    public static boolean isArmstrong(int a) {
        if (a == povSum(a)) return true;
        return false;
    }

    public static boolean isUnique(int b) {
        int leftDigit = b % 10;
        int currentDigit;
        int a = b / 10;


        while (a != 0) {
            currentDigit = a % 10;
            if (currentDigit > leftDigit && leftDigit != 0) return false;
            else {
                leftDigit = currentDigit;
                a = a / 10;
            }
        }
        return true;
    }

    public static int povSum(int a) {
        int digits = String.valueOf(a).length();;
        int sum = 0;
        int b = a;
        while (b != 0) {
            int t = b%10;
            int c = t;
            for (int i = 1; i < digits; i++) {
                t *= c;
            }
            sum += t;
            b = b / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        int[] a = getNumbers(1000000000);
//        for (int s: a) {
//            System.out.println(s);
//        }
        long end = System.currentTimeMillis();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        System.out.println(end - start + " ms");
        System.out.println(((memoryStart - memoryEnd) / (8 * 1024 * 1024) + " MB"));
    }
}
