package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable {

        public static void main(String args[]) throws Exception {
            FileOutputStream fileOutput = new FileOutputStream("your.file.name");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

            Person p = new Person("Misha", "Goncharenko", "Russia", Sex.MALE);
            outputStream.writeObject(p);

            fileOutput.close();
            outputStream.close();

            //loading
            FileInputStream fiStream = new FileInputStream("your.file.name");
            ObjectInputStream objectStream = new ObjectInputStream(fiStream);

            Person loadedObject = (Person) objectStream.readObject();

            fiStream.close();
            objectStream.close();

            //Attention!!
            System.out.println(p);
            System.out.println(loadedObject);
        }

        private static final long serialVersionUID = 4L;

        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.fullName = String.format("%s, %s", lastName, firstName);
            outputStream = System.out;
            logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex implements Serializable {
        MALE,
        FEMALE
    }
}
