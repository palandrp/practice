package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Naatsms on 31.01.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {
        String result = String.valueOf(i % 2);
        if (i / 2 > 0) {
            BinaryRepresentationTask child = new BinaryRepresentationTask(i / 2);
            child.fork();
            result = child.join() + result;
        }
        return result;
    }
}
