package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    static int key = 7;

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) encode(args[1], args[2]);
        if (args[0].equals("-d")) decode(args[1], args[2]);
    }

    public static void decode(String in, String out) throws IOException {
        FileInputStream fin = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out);

        while (fin.available() > 0) {
            fos.write(fin.read() ^ key);
        }
        fin.close();
        fos.close();
    }

    public static void encode(String in, String out) throws IOException {
        FileInputStream fin = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out);

        while (fin.available() > 0) {
            fos.write(fin.read() ^ key);
        }
        fin.close();
        fos.close();
    }


}
