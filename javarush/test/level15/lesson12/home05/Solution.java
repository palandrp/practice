package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution (String a, String b, int c) {}
    public Solution (String a, String b) {}
    public Solution (String a) {}

    Solution (String a, String b, double c) {}
    Solution (String a, double c) {}
    Solution (double c) {}

    protected Solution (String a, String b, String c, int d) {}
    protected Solution (String a, double c, int d) {}
    protected Solution (double c, int d) {}

    private Solution (int d) {}
    private Solution (double c, int d, int e) {}
    private Solution (double c, double d) {}
}

