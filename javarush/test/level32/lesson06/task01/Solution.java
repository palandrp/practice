package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] digits = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        byte[] lowerCase = new byte[26];
        byte[] upperCase = new byte[26];
        byte a = 65;
        byte b = 97;
        for (int i = 0; i < 26; i++) {
            lowerCase[i] = b++;
            upperCase[i] = a++;
        }
        byte[][] chars = new byte[][]{digits, lowerCase, upperCase};

        byte[] password = new byte[8];

        while (true) {
            boolean d = false;
            boolean u = false;
            boolean l = false;

            for (int i = 0; i < 8; i++) {
                int n = (int) (Math.random() * 3);
                if (n == 0) d = true;
                if (n == 1) u = true;
                if (n == 2) l = true;
                int m = 0;
                if (n == 0) m = (int) (Math.random() * 10);
                else m = (int) (Math.random() * 26);
                password[i] = chars[n][m];
            }
            if (d && u && l) break;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(8);
        try {
            out.write(password);
        } catch (IOException ignored) {}

        return out;
    }
}
