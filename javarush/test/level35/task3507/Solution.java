package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("C:\\Users\\Юля\\Documents\\Java Codes\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task35\\task3507\\data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        Path source = Paths.get(pathToAnimals);
        System.out.println(source);
        FileClassLoader fcl = new FileClassLoader();
        try {
            List<Path> list = Files.list(source).collect(Collectors.toList());
            for (Path p : list) {
                try {
                    Class clazz = fcl.findClass(p.toString());
                    set.add((Animal)clazz.newInstance());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |ClassFormatError e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return set;
    }

    public static class FileClassLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Path classFile = Paths.get(name);
            System.out.println(classFile);
            try {
                byte[] arr = Files.readAllBytes(classFile);
                String s = new String(arr);
                System.out.println(s);
                return defineClass(null, arr, 0, arr.length);
            } catch (IOException e) {
                return null;
            }
        }
    }
}
