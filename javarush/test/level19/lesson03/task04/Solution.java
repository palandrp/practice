package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScannerAdapter in = new PersonScannerAdapter(new Scanner(new File("test.txt")));
        System.out.println(in.read());
        System.out.println(in.read());
        in.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner in;

        public PersonScannerAdapter(Scanner ps) {
            in = ps;
        }

        @Override
        public Person read() throws IOException {
            Calendar cal = new SimpleDateFormat("dd MM yyyy").getCalendar();
            String lastName = in.next();
            String name = in.next();
            String secName = in.next();
            int day = in.nextInt();
            int month = in.nextInt() - 1;
            int year = in.nextInt();
            cal.set(year, month, day);
            return new Person(name, secName, lastName, cal.getTime());
        }

        @Override
        public void close() throws IOException {
            in.close();
        }
    }
}
