package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass().equals(getClass())) {
            Solution n = (Solution) obj;
            if (n.first != null && n.last != null) {
                return n.first.equals(first) && n.last.equals(last);
            }
            if (n.first != null) return n.first.equals(first);
            if (n.last != null) return n.last.equals(last);
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (last == null && first == null) return 0;
        if (first == null) return last.hashCode();
        if (last == null) return 31 * first.hashCode();
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        Solution a = new Solution("Donald", null);
        Solution b = new Solution(null, "Duck");
        dos(b);
        System.out.println(b.first);

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

    public static void dos(Solution o) {
        o.first = "Surprise";
    }
}
