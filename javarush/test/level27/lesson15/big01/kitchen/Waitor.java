package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Waitor implements Runnable {
    private LinkedBlockingQueue<Order> queue;
    private boolean busy;

    public boolean isBusy() {
        return busy;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                deliveryOrder(queue.take());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void deliveryOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage(order + " was cooked by " + order.getCook());
        Thread.sleep(500);
        busy = false;
    }

}
