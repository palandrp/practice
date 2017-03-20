package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = new File("test2.txt");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov.equals(somePerson));
            System.out.println(somePerson.name + " " + somePerson.assets.get(0).getName());
            System.out.println(somePerson.name + " " + somePerson.assets.get(1).getName());
            System.out.println(ivanov.name + " " + ivanov.assets.get(0).getName());
            System.out.println(ivanov.name + " " + ivanov.assets.get(1).getName());
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintStream out = new PrintStream(outputStream);
            out.println(name);
            out.println(assets.size());
            for (Asset a: assets) {
                out.println(a.getName());
            }
            out.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            this.name = in.readLine();
            int assetsCount = Integer.parseInt(in.readLine());
            if (assetsCount != 0) {
                for (int i = 0; i < assetsCount; i++) {
                    this.assets.add(new Asset(in.readLine()));
                }
            }
            in.close();
        }
    }
}
