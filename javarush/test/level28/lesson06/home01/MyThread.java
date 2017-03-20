package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    private static AtomicInteger threadPriority = new AtomicInteger(1);
    private ThreadGroup group;

    public MyThread() {
        super();
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

    private void init() {
        group = Thread.currentThread().getThreadGroup();
        int groupPriority = group.getMaxPriority();
        int priority = 0;
        if (threadPriority.get() == 10) priority = threadPriority.getAndSet(1);
        else priority = threadPriority.getAndIncrement();
        setPriority(priority);
    }

}
