package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        if (n.first != null && n.last != null) {
            return n.first.equals(first) && n.last.equals(last);
        }
        if (n.first != null) return n.first.equals(first);
        if (n.last != null) return n.last.equals(last);
        return true;
    }

    @Override
    public int hashCode() {
        if (last == null && first == null) return 0;
        if (first == null) return last.hashCode();
        if (last == null) return 31 * first.hashCode();
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
