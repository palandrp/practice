package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {

    static int count;

    static int id = 10;

    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileInputStream reader = new FileInputStream(args[0]);
        int data;
        while(reader.available() > 0){
            int a = reader.read();
            if(a > 64 && a < 91 || a > 96 && a < 123){
                count++;
            }
        }
        reader.close();
        System.out.println(count);
    }
}