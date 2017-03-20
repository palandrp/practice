package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        FileClassLoader fcl = new FileClassLoader();
        Path dir = Paths.get(packageName);
        try {
            List<Path> list = Files.list(dir).collect(Collectors.toList());
            for (Path a : list) {
                Class cl = fcl.findClass(a.toString());
                if (cl != null) {
                    hiddenClasses.add(cl);
                }
            }
        } catch (IOException ignored) {}
    }

    public HiddenClass getHiddenClassObjectByKey(String key)
    {
        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] con = clazz.getDeclaredConstructors();
                    for (Constructor constr : con) {
                        if (constr.getParameterTypes().length == 0) {
                            constr.setAccessible(true);
                            return (HiddenClass) constr.newInstance();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    return null;
    }

    public static class FileClassLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Path classFile = Paths.get(name);
            System.out.println(classFile.getFileName().toString());
            if (!(classFile.getFileName().toString().endsWith(".class"))) return null;
            try {
                byte[] arr = Files.readAllBytes(classFile);
                String s = new String(arr);
                return defineClass(null, arr, 0, arr.length);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    }

}

