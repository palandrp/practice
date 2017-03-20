package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        System.out.println(nod(a, b));
    }

    public static int nod(int a, int b) {
        int od = 0;
        if (a > b) {
            od = a % b;
            if (od == 0) return b;
            else return nod(a, od);
        }
        else {
            od = b % a;
            if (od == 0) return a;
            else return nod(b, od);
        }
    }
}
