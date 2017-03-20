package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    public static class A {
        protected String name = "A";

        public A(){
        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        final static long serialVersionUID = 1L;

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(name);
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.name = (String) stream.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"));
        B sol = new Solution().new B("name");
        System.out.println(sol.name);
        out.writeObject(sol);
        B ail = (B) in.readObject();
        System.out.println(ail.name);
        System.out.println(sol.name.equals(ail.name));
    }

}
