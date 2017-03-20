package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {

    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("test.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();
            object.string1.print();
            object.string2.print();
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            loadedObject.string1.print();
            loadedObject.string2.print();
            System.out.println(object.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintStream out = new PrintStream(outputStream);
            PrintStream def = System.out;
            System.setOut(out);

            boolean isString1 = string1 != null;
            System.out.println(isString1);
            if (isString1) string1.print();

            boolean isString2 = string2 != null;
            System.out.println(isString2);
            if (isString2) string2.print();

            System.setOut(def);
            out.close();
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            if (Boolean.parseBoolean(in.readLine())) {
                java.lang.String line = in.readLine();
                int number = Integer.parseInt(line.split("#")[1]);

                synchronized (Object.class) {
                    int cur = countStrings;
                    countStrings = number - 1;
                    string1 = new String();
                    countStrings = cur;
                }
            }
            if (Boolean.parseBoolean(in.readLine())) {
                java.lang.String line = in.readLine();
                int number = Integer.parseInt(line.split("#")[1]);

                synchronized (Object.class) {
                    int cur = countStrings;
                    countStrings = number - 1;
                    string2 = new String();
                    countStrings = cur;
                }
            }
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
