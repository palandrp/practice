package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        RandomAccessFile rf = new RandomAccessFile(args[0], "rw");
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        byte[] arr = new byte[text.length()];
        rf.seek(number);
        rf.read(arr, 0, arr.length);
        String result = convertByteToString(arr);
        rf.seek(rf.length());

        if (result.equals(text)) rf.write("true".getBytes());
        else rf.write("false".getBytes());
        rf.close();
    }

    private static String convertByteToString(byte[] arr) {
        return new String(arr);
    }
}
