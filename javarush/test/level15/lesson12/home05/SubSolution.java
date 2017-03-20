package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution {
    public SubSolution(String a, String b, int c) {
        super(a, b, c);
    }

    public SubSolution(String a, String b) {
        super(a, b);
    }

    public SubSolution(String a) {
        super(a);
    }

    SubSolution(String a, String b, double c) {
        super(a, b, c);
    }

    SubSolution(String a, double c) {
        super(a, c);
    }

    SubSolution(double c) {
        super(c);
    }

    protected SubSolution(String a, String b, String c, int d) {
        super(a, b, c, d);
    }

    protected SubSolution(String a, double c, int d) {
        super(a, c, d);
    }

    protected SubSolution(double c, int d) {
        super(c, d);
    }

    private SubSolution (int d) {
        super(d);
    }
    private SubSolution (double c, int d, int e) {
        super(c, e);
    }
    private SubSolution (double c, double d) {
        super(d);
    }
}
