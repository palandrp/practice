package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse ho : horses) {
            ho.move();
        }
    }

    public void print() {
        for (Horse ho : horses) {
            ho.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse max = null;
        double dist = 0;
        for (Horse a : horses) {
            if (a.getDistance() > dist) {
                max = a;
                dist = a.getDistance();
            }
        }
        return max;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse a1 = new Horse("buba", 3, 0);
        Horse a2 = new Horse("lova", 3, 0);
        Horse a3 = new Horse("roma", 3, 0);
        ArrayList<Horse> list = game.getHorses();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        game.run();
        game.printWinner();
    }
}
