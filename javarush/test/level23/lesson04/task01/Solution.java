package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution a = new Solution();
        a.innerClasses = new InnerClass[]{
            a.new InnerClass(),
            a.new InnerClass()
        };
        Solution b = new Solution();
        b.innerClasses = new InnerClass[]{
            b.new InnerClass(),
            b.new InnerClass()
        };
        return new Solution[]{
            a, b
        };
    }
}
