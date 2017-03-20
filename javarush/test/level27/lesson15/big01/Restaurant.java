package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();
    private static final LinkedBlockingQueue<Order> READY_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Cook cook = new Cook("Amigo");
        cook.setQueue(QUEUE);
        cook.setReadyQueue(READY_QUEUE);
        Thread c1 = new Thread(cook);

        Cook cook2 = new Cook("Babigo");
        cook2.setQueue(QUEUE);
        cook2.setReadyQueue(READY_QUEUE);
        Thread c2 = new Thread(cook2);

        Waitor waitor = new Waitor();
        waitor.setQueue(READY_QUEUE);
        Thread w1 = new Thread(waitor);

        c1.start();
        c2.start();
        w1.start();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++ ) {
            Tablet a = new Tablet(i + 1);
            a.setQueue(QUEUE);
            tablets.add(a);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread generator = new Thread(task);
        generator.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        generator.interrupt();

        while (!QUEUE.isEmpty()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }

        while ((cook2.isBusy())||(cook.isBusy())) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }

        c1.interrupt();
        c2.interrupt();

        while ((waitor.isBusy() || !READY_QUEUE.isEmpty())) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
        w1.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
