package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{

    private FileOutputStream adapter;

    public AdapterFileOutputStream(FileOutputStream a) {
        adapter = a;
    }

    @Override
    public void flush() throws IOException {
        adapter.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        adapter.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        adapter.close();
    }
}

