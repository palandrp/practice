package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream def = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream fake = new ContextPrintStream(buf);
        System.setOut(fake);
        testString.printSomething();
        System.setOut(def);
        System.out.println(buf.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    static class ContextPrintStream extends PrintStream {
        static int messageCount = 1;
        final static String MESSAGE = "JavaRush - курсы Java онлайн";

        public ContextPrintStream(OutputStream out) {
            super(out);
        }

        public ContextPrintStream(OutputStream out, boolean autoFlush) {
            super(out, autoFlush);
        }

        public ContextPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
            super(out, autoFlush, encoding);
        }

        public ContextPrintStream(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        public ContextPrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(fileName, csn);
        }

        public ContextPrintStream(File file) throws FileNotFoundException {
            super(file);
        }

        public ContextPrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(file, csn);
        }

        @Override
        public void print(boolean b) {
            super.print(b);
        }

        @Override
        public void print(char c) {
            super.print(c);
        }

        @Override
        public void print(int i) {
            super.print(i);
        }

        @Override
        public void print(long l) {
            super.print(l);
        }

        @Override
        public void print(float f) {
            super.print(f);
        }

        @Override
        public void print(double d) {
            super.print(d);
        }

        @Override
        public void print(char[] s) {
            super.print(s);
        }

        @Override
        public void print(String s) {
            super.print(s);
        }

        @Override
        public void print(Object obj) {
            super.print(obj);
        }

        @Override
        public void println() {
            super.println();
            checkContext();
        }

        @Override
        public void println(boolean x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(char x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(int x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(long x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(float x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(double x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(char[] x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(String x) {
            super.println(x);
            checkContext();
        }

        @Override
        public void println(Object x) {
            super.println(x);
            checkContext();
        }

        private void checkContext() {
            messageCount++;
            if (messageCount % 3 == 0) {
                println(MESSAGE);
            }
        }

    }

}
