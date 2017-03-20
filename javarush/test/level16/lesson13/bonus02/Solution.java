package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new EndlessThread());
        threads.add(new ExThread());
        threads.add(new HurThread());
        threads.add(new MesThread());
        threads.add(new InThread());
    }

    public static void main(String[] args) {
        ExThread a = new ExThread();
        a.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }

}

class EndlessThread extends Thread {
    @Override
    public void run() {
        while(true) {
        }
    }
}
class ExThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
}
class HurThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MesThread extends Thread implements Message {
    @Override
    public void run() {
        while(!isInterrupted()){
        }
    }

    @Override
    public void showWarning() {
        try {
            interrupt();
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class InThread extends Thread {
    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            try {
                String line = in.readLine();
                if (line.equals("N")) break;
                else sum += Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
    }
}
