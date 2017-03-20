package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("test2.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User us1 = new User();
            us1.setFirstName("Misha");
            us1.setLastName("Gocharenko");
            us1.setBirthDate(new Date());
            us1.setMale(true);
            us1.setCountry(User.Country.valueOf("OTHER"));
            javaRush.users.add(us1);
            User us2 = new User();
            us2.setFirstName("Masha");
            us2.setLastName("Potapchenko");
            us2.setMale(false);
            us2.setCountry(User.Country.valueOf("RUSSIA"));
            javaRush.users.add(us2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.equals(javaRush)); //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter out = new PrintWriter(outputStream);
            out.println(users.size());
            for (int i = 0; i < users.size(); i++) {

                boolean isFirstName = users.get(i).getFirstName() != null;
                out.println(isFirstName);
                if (isFirstName) out.println(users.get(i).getFirstName());

                boolean isLastName = users.get(i).getLastName() != null;
                out.println(isLastName);
                if (isLastName) out.println(users.get(i).getLastName());

                boolean isDate = users.get(i).getBirthDate() != null;
                out.println(isDate);
                if (isDate) out.println(users.get(i).getBirthDate().getTime());

                out.println(users.get(i).isMale());

                boolean isCountry = users.get(i).getCountry() != null;
                out.println(isCountry);
                if (isCountry) out.println(users.get(i).getCountry().getDisplayedName().toUpperCase());
            }
            out.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(in.readLine());
            for (int i = 0; i < usersSize; i++) {
                User one = new User();
                if (Boolean.parseBoolean(in.readLine())) {
                    one.setFirstName(in.readLine());
                }
                if (Boolean.parseBoolean(in.readLine())) {
                    one.setLastName(in.readLine());
                }
                if (Boolean.parseBoolean(in.readLine())) {
                    one.setBirthDate(new Date(Long.parseLong(in.readLine())));
                }
                one.setMale(Boolean.parseBoolean(in.readLine()));
                if (Boolean.parseBoolean(in.readLine())) {
                    one.setCountry(User.Country.valueOf(in.readLine()));
                }
                users.add(one);
            }
            in.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof JavaRush)) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }



}
