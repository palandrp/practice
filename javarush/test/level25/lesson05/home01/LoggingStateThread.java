package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Юля on 16.01.2017.
 */
public class LoggingStateThread extends Thread {
    Thread search;
    Thread.State curState;

    public LoggingStateThread(Thread search) {
        this.search = search;
        curState = search.getState();
        System.out.println(curState);
        setDaemon(true);

    }

    @Override
    public void run() {
        do {
            if (search.getState() != curState) {
                curState = search.getState();
                System.out.println(curState);
            }
        } while (curState != Thread.State.TERMINATED);
        interrupt();
    }
}
