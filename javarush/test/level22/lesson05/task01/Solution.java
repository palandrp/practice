package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws TooShortStringException {
        long start = System.currentTimeMillis();
        System.out.println(getPartOfString("первое  второе   третье   четвертое пятое"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        System.out.println(getPartOfString2("первое  второе   третье   четвертое пятое"));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        if (string.split("[^ ]").length < 5) throw new TooShortStringException();
        int start = string.indexOf(" ");
        int next = start;
        for (int i = 0; i < 3; i++) {
            next = string.indexOf(" ", next + 1);
            if (next == -1) throw new TooShortStringException();
        }
        String sub = string.substring(next+1);
        try {
            sub = sub.split("[ /.,]")[0];
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return (string.substring(start + 1, next+1) + sub);
    }

    public static String getPartOfString2(String string) throws TooShortStringException{
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        if (string.split("[^ ]").length < 5) throw new TooShortStringException();
        Pattern p = Pattern.compile("(?:\\ )((\\S+)?((\\ )(\\S+)?){3})");
        Matcher m = p.matcher(string);
        m.find();
        return m.group(1);
    }

    public static class TooShortStringException extends Exception {
    }

}
